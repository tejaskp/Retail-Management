package com.example.ws.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ws.data.ShopArray;
import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;
import com.example.ws.model.georesponse.GoogleResponse;
import com.example.ws.util.ApplicationUtils;

@Service
public class ManagerServiceImpl implements ManagerService {

	private Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;


	@Override
	public Shop addShop(Shop shop) throws DataNotFoundException{

		String methodName="addShop()";
		logger.info("Entering "+methodName);

		Double shopLongitude=null;
		Double shopLatitude=null;
		String url=ApplicationUtils.getLonLatUrl(shop.getShopAddress().getNumber(), shop.getShopAddress().getPostCode());
		
		//Calling Geocoding API to fetch Longitude and Latitude
		GoogleResponse  googleResponse= restTemplate.getForObject(url, GoogleResponse.class);
		
		if(googleResponse.getStatus().equalsIgnoreCase("OK")){
			shopLongitude=googleResponse.getResults()[0].getGeometry().getLocation().getLng();
			shopLatitude=googleResponse.getResults()[0].getGeometry().getLocation().getLat();
		}
		else{
			throw new DataNotFoundException(googleResponse.getStatus()+ ": Location not found");
		}
		shop.setShopLongitude(shopLongitude);
		shop.setShopLatitude(shopLatitude);
		ShopArray.shops.add(shop);

		logger.info("Entering "+methodName);
		return shop;
	}

}
