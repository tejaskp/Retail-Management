package com.example.ws.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Shop {

	@NotNull
	private String shopName;
	
	@Valid
	private Address shopAddress;
	
	private Double shopLongitude;
	
	private Double shopLatitude;

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public Address getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * @return the shopLongitude
	 */
	public Double getShopLongitude() {
		return shopLongitude;
	}

	/**
	 * @param shopLongitude the shopLongitude to set
	 */
	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	/**
	 * @return the shopLatitude
	 */
	public Double getShopLatitude() {
		return shopLatitude;
	}

	/**
	 * @param shopLatitude the shopLatitude to set
	 */
	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

}
