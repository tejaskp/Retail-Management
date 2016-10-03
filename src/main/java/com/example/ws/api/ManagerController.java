package com.example.ws.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;
import com.example.ws.service.ManagerService;

@RestController
@RequestMapping("/RetailManagementSystem")
public class ManagerController {

	private Logger logger = LoggerFactory.getLogger(ManagerController.class);

	@Autowired
	private ManagerService managerService;

	@RequestMapping(
			value = "/addShop",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> addShop(@Valid @RequestBody Shop shop) throws DataNotFoundException{

		String methodName="addShop()";
		logger.info("Entering "+methodName);

		Shop savedShop = managerService.addShop(shop);				    	

		logger.info("Exiting "+methodName);
		return new ResponseEntity<Shop>(savedShop,HttpStatus.CREATED);
	}


}
