package com.example.ws.service;

import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;

public interface CustomerService{

	public Shop getNearestShop(Double customerLongitude,Double customerLatitude) throws DataNotFoundException;
}
