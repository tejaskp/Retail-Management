package com.example.ws.service;

import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.ws.data.ShopArray;
import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;
import com.example.ws.util.ApplicationUtils;


@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Shop getNearestShop(Double customerLongitude, Double customerLatitude) throws DataNotFoundException{
		String methodName="getNearestShop()";
		logger.info("Entering "+methodName);
		
		if(ShopArray.shops.size()==0){
			throw new DataNotFoundException("Shop list is Empty");
		}
		
		//Logic to find nearest shop
		ListIterator<Shop> iterator=ShopArray.shops.listIterator();
		Shop shop=null;
		Double distance=0d;
		while(iterator.hasNext()){

			Shop currentShop=iterator.next();
			if(iterator.previousIndex()==0){

				distance = ApplicationUtils.getDistance(customerLatitude, customerLongitude, currentShop.getShopLatitude(), currentShop.getShopLongitude());
				shop=currentShop;
			}
			else{
				
				Double currentIDistance = ApplicationUtils.getDistance(customerLatitude, customerLongitude, currentShop.getShopLatitude(), currentShop.getShopLongitude());
				if(currentIDistance<distance){
					shop=currentShop;
					distance=currentIDistance;
				}
			}
		}
		logger.info("Nearest shop :"+shop.getShopName());
		logger.info("Exiting "+methodName);
		return shop;
	}

}
