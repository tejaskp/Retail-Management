package com.example.ws.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.ws.AbstractTest;
import com.example.ws.model.Address;
import com.example.ws.model.Shop;

public class ControllerTest extends AbstractTest {

    @Before
    public void setUp(){
    	super.setUp();
    }
	
    //Method to test /addShop api (addShop method of ManagerController)
    @Test
    public void testAddShop() throws Exception {

        String url = "/RetailManagementSystem/addShop";
        Address testAddress=new Address();
        testAddress.setNumber("1");
        testAddress.setPostCode("411007");
		Shop testShop=new Shop();
		testShop.setShopName("Test Shop 1");
		testShop.setShopAddress(testAddress);
		
        String inputJson = super.mapToJson(testShop);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson).header("user", "manager"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 201", 201, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

        Shop createdShop = super.mapFromJson(content, Shop.class);

        Assert.assertNotNull("failure - expected shop not null", createdShop);
        Assert.assertNotNull("failure - expected shop.shopLongitude not null", createdShop.getShopLongitude());
        Assert.assertNotNull("failure - expected shop.shopLatitude not null", createdShop.getShopLatitude());

    }
    
    //Method to test /getNearestShop api (getNearestShop method of CustomerController)
    @Test
    public void testGetNearestShop() throws Exception {
    	
        String url = "/RetailManagementSystem/getNearestShop/{testCustomerLongitude}/{testCustomerLatitude}";
        String testCustomerLongitude="74.5535172";
        String testCustomerLatitude="18.4416573";
        
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url, new Object[]{testCustomerLongitude,testCustomerLatitude}).
        		contentType(MediaType.APPLICATION_JSON).header("user", "customer")).andReturn();

        String content = result.getResponse().getContentAsString();

        int status = result.getResponse().getStatus();

        Assert.assertEquals("failure - expected HTTP status 200", 200, status);
        Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);

    }

}
