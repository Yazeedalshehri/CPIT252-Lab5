package edu.kau.fcit.cpit252;

import com.maxmind.geoip2.record.Location;

import edu.kau.fcit.cpit252.geoLocation.GeoLocation;
import edu.kau.fcit.cpit252.weatherDB.WeatherDBI;
import edu.kau.fcit.cpit252.weatherDB.WeatherInfo;

public class App {
    public static void main(String[] args) {
        // Jeddah => 21.543333, 39.172778
    	
    	
    	
    	WeatherCity city = new WeatherDBI();
    	WeatherDBI dbi = new WeatherDBI();
    	WeatherGeo GPS = new WeatherInfo(dbi);
    	
    	
    	System.out.println("Location");
    	var sendGPS = GPS.getWeatherInfo(21.543333,39.172778);
    	
    	System.out.println("Jeddah");
    	System.out.println(city.getWeatherInfo("Jeddah"));
    	
    	System.out.println("Jeddah by GPS");
    	System.out.println(sendGPS);	
    	
    	
    	
    }
}
