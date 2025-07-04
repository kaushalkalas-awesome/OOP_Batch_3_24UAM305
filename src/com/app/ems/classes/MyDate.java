package com.app.ems.classes;

import com.app.ems.classes.exceptions.InvalidDateException;

public class MyDate {
	private int day, month, year;

	public MyDate(int day, int month, int year) throws InvalidDateException {
		if(day>31 || day<0)
			throw new InvalidDateException();
		if(month>12 || month<0)
			throw new InvalidDateException();
		
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d-%d",day,month,year);
	}
	
}
