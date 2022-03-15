package edu.kau.fcit.cpit252.geoLocation;

import java.util.HashMap;
import java.util.Map;

public class GeoLocation {

    private final Map<Location,String> GEO_LOCATIONS = new HashMap<Location, String>();

    public GeoLocation() {
        GEO_LOCATIONS.put(new Location(21.383333, 39.850000), "Makkah");
        GEO_LOCATIONS.put(new Location(24.466667, 39.6), "Medina");
        GEO_LOCATIONS.put(new Location(21.543333, 39.172778), "Jeddah");
        GEO_LOCATIONS.put(new Location(24.633333, 46.716667), "Riyadh");
        GEO_LOCATIONS.put(new Location(28.397222, 36.578889), "Tabuk");
        GEO_LOCATIONS.put(new Location(26.283333, 50.2), "Khobar");
        GEO_LOCATIONS.put(new Location(18.216944, 42.505278), "Abha");
        GEO_LOCATIONS.put(new Location(16.889167, 42.561111), "Jazan");
    }

    public String search(double latitude, double longitude){
        return GEO_LOCATIONS.get(new Location(latitude, longitude));
    }
}
