package com.example.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	//Exception handler to handle DataNotFoundException Exception
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleApplicationException(DataNotFoundException applicationException){
		
		ExceptionInfo exceptionInfo = new ExceptionInfo(HttpStatus.NOT_FOUND.value(), applicationException.getMessage());
		return new ResponseEntity<ExceptionInfo>(exceptionInfo,HttpStatus.NOT_FOUND);
	
	}
	
	//Exception handler to handle generic Exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionInfo> handleException(Exception exception){
		
		ExceptionInfo exceptionInfo = new ExceptionInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
		return new ResponseEntity<ExceptionInfo>(exceptionInfo,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
