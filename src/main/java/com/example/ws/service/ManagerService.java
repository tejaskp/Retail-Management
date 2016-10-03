package com.example.ws.service;

import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;

public interface ManagerService {
	
	public Shop addShop(Shop shop) throws DataNotFoundException;

}
