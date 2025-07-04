package com.app.ems.classes;

public class Employee extends Person {
	private int id;
	private String department;
	private double salary;
	public MyDate dateOfJoining;
	
	public Employee(String name, int id, String department, double salary, MyDate dateOfBirth,MyDate dateOfJoining) {
		super(name,dateOfBirth);
		this.id = id;
		this.department = department;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		super.toString();
		return String.format("\nId: %d\nDepartment: %s\nSalary: %f",id,department,salary);
	}
	
}
