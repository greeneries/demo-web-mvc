package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MyError extends Throwable{

	private Integer errorCode;
	private String message;
	
	
	
	public MyError(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
