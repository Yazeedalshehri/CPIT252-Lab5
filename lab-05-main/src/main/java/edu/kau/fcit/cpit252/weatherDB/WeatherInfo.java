package edu.kau.fcit.cpit252.weatherDB;

import com.fasterxml.jackson.annotation.JsonProperty;

import edu.kau.fcit.cpit252.WeatherCity;
import edu.kau.fcit.cpit252.WeatherGeo;
import edu.kau.fcit.cpit252.geoLocation.GeoLocation;

import java.util.Map;

public class WeatherInfo implements WeatherGeo {
    @JsonProperty("dayhour")
    private String time;
    private double tempInC;
    private double tempInF;

    WeatherDBI dbi ;
   
    GeoLocation geoLocation = new GeoLocation();
    
    
    public WeatherInfo(WeatherDBI newdbi) {
    	
		this.dbi = newdbi;
		
	}
    
    public WeatherInfo() {
		// TODO Auto-generated constructor stub
	}
   
    
    
    @SuppressWarnings("unchecked")
    @JsonProperty("temp")
    private void unpackNested(Map<String,Object> temp) {
        this.tempInC = (double)temp.get("c");
        this.tempInF = (double)temp.get("f");
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTempInC() {
        return tempInC;
    }

    public void setTempInC(double tempInC) {
        this.tempInC = tempInC;
    }

    public double getTempInF() {
        return tempInF;
    }

    public void setTempInF(double tempInF) {
        this.tempInF = tempInF;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "time='" + time + '\'' +
                ", tempInC=" + tempInC +
                ", tempInF=" + tempInF +
                '}';
    }
    
   

	@Override
	public String getWeatherInfo(double latitude, double longitude) {
		String cityname = geoLocation.search(latitude, longitude);
		
		return dbi.getWeatherInfo(cityname);
	}


	
}
