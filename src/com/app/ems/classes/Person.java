package com.app.ems.classes;

public class Person {
	private String name;
	public static MyDate dateOfBirth;

	public Person(String name) {
		this.name = name;
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
