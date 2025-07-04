package com.app.ems.classes.exceptions;

public class InvalidDateException extends Exception {
	
	@Override
	public String getMessage() {
		return String.format("Please enter valid month or day");
	}
}
