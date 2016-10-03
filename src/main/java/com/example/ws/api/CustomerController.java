package com.example.ws.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ws.exception.DataNotFoundException;
import com.example.ws.model.Shop;
import com.example.ws.service.CustomerService;

@RestController
@RequestMapping("/RetailManagementSystem")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(
			value = "/getNearestShop/{customerLongitude}/{customerLatitude}",
			method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> getNearestShop(@PathVariable("customerLongitude") Double customerLongitude,
			@PathVariable("customerLatitude") Double customerLatitude) throws DataNotFoundException{
		
		String methodName="getNearestShop()";
		logger.info("Entering "+methodName);

		Shop nearestShop = customerService.getNearestShop(customerLongitude, customerLatitude);
		
		logger.info("Exiting "+methodName);
		return new ResponseEntity<Shop>(nearestShop,HttpStatus.OK);
	}
}
