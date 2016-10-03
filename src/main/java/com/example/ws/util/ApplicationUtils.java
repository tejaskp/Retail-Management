package com.example.ws.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApplicationUtils {

	//Google Geocoding API URL
	public static final String GOOGLE_URL="https://maps.googleapis.com/maps/api/geocode/json";

	public static final String API_KEY="xxxxxxxx";
	
	public static String getLonLatUrl(String shopNumber,String shopPostCode){

		return GOOGLE_URL+"?address="+shopNumber+"+"
				+shopPostCode+"&key="+API_KEY;
		
	}
	
	//Method to calculate distance in km between two points based on Longitudes and Latitudes
	public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double distance = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		distance = Math.acos(distance);
		distance = rad2deg(distance);
		distance = distance * 60 * 1.1515;
		distance = distance * 1.609344;
		return distance;
	}

	
	//This function converts decimal degrees to radians
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	
	//This function converts radians to decimal degrees
	
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
    //Object to Json string converted
    public static String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
   
    //Json string to Object converter
    public static <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
}
