package com.app.ems.classes;

import com.app.ems.classes.exceptions.InvalidDateException;

public class MyDate {
	private int day, month, year;

	public MyDate(int day, int month, int year) throws InvalidDateException {
		if(this.day>31 || this.day<0)
			throw new InvalidDateException("Date",this.day);
		else if(this.month>12 || this.month<0)
			throw new InvalidDateException("Month",this.month);
		else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
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
