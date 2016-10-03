package com.example.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.ws.interceptor.AddShopAccessInterceptor;
import com.example.ws.interceptor.GetNearestShopInterceptor;

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AddShopAccessInterceptor()).addPathPatterns("/RetailManagementSystem/addShop");
        registry.addInterceptor(new GetNearestShopInterceptor()).addPathPatterns("/RetailManagementSystem/getNearestShop/**");
        
    }

}
