package com.app.ems.classes;

public class Person {
	private String name;
	public MyDate dateOfBirth;

	public Person(String name, MyDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("\nName: %s", this.name);
	}
	
}
