package edu.kau.fcit.cpit252.weatherDB;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kau.fcit.cpit252.WeatherCity;
import edu.kau.fcit.cpit252.utils.HTTPHelper;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

// The Adaptee class, WeatherDBI, takes a city name and returns the weather forecast.
public class WeatherDBI implements WeatherCity {

    private final String API_URL = "https://weatherdbi.herokuapp.com/data/weather/";

    @Override
    public String getWeatherInfo(String city) {
        // build the URL 
        WeatherInfo wInfo = null;
        URIBuilder b = null;
        try {
            b = new URIBuilder(API_URL + city);
            URI uri = b.build();
            HttpResponse<String> response = HTTPHelper.sendGet(uri);
            if (response != null) {
                wInfo = parseWeatherResponse(response.body(), WeatherInfo.class);
                return wInfo.toString();
            }
            return "failed";
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
    public static WeatherInfo parseWeatherResponse(String responseString, Class<?> elementClass){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode weatherInfoNode = objectMapper.readTree(responseString);
            WeatherInfo wInfo = new WeatherInfo();
            String dayHour = weatherInfoNode.get("currentConditions").get("dayhour").textValue();
            int tempC = weatherInfoNode.get("currentConditions").get("temp").get("c").intValue();
            int tempF = weatherInfoNode.get("currentConditions").get("temp").get("f").intValue();

            wInfo.setTime(dayHour);
            wInfo.setTempInC(tempC);
            wInfo.setTempInF(tempF);

            return wInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

