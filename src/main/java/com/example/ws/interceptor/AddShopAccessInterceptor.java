package com.example.ws.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.ws.exception.ExceptionInfo;
import com.example.ws.util.ApplicationUtils;

public class AddShopAccessInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
		
		logger.info("Entering AddShopAccessInterceptor");
		if(request.getHeader("user") != null && request.getHeader("user").equalsIgnoreCase("manager")){
			logger.info("Authentication success for user "+request.getHeader("user"));
			return true;
		}
		logger.info("Authentication failed for user "+request.getHeader("user"));
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ExceptionInfo exceptionInfo=new ExceptionInfo(HttpStatus.UNAUTHORIZED.value(),
				"Authentication failed");
		response.getWriter().write(ApplicationUtils.mapToJson(exceptionInfo));
		logger.info("Entering AddShopAccessInterceptor");
		return false;
	}
	
}
