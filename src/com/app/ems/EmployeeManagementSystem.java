package com.app.ems;
import java.util.Scanner;
import com.app.ems.classes.*;
import com.app.ems.classes.exceptions.InvalidDateException;

public class EmployeeManagementSystem {
	
	final static int MAX_EMPLOYEE_SIZE = 10;
	static int counter = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee[] employee = new Employee[MAX_EMPLOYEE_SIZE];
		
		enum Emp_Task{
			INVALID ,ADD_EMP, DISPLAY_ALL_EMP, SEARCH_EMP_BY_ID, DISPLAY_EMP_JOIN_YEAR, FIND_EMP_MAX_SALARY, FIND_EMP_MIN_SALARY, EXIT;
		}
		
		Emp_Task[] emp_task = Emp_Task.values();
		
		while(true) {
			for(int j=1; j<emp_task.length; j++) {
				System.out.println(emp_task[j].ordinal()+". "+emp_task[j].name());
			}
			System.out.print("Enter your choice: ");
			int i = sc.nextInt();
			Emp_Task choice = emp_task[i];
			
			switch(choice) {
				case INVALID: System.out.println("Invalid Choice");
					break;
				
				case ADD_EMP:
					sc.nextLine();
					System.out.println("Enter Employee Name:");
					String name = sc.nextLine();
					System.out.println("Enter Employee DOB: ");
					int day = sc.nextInt();
					int month = sc.nextInt();
					int year = sc.nextInt();
					try{
						employee[counter].dateOfBirth = new MyDate(day,month,year);
					} catch(InvalidDateException e) {
						System.out.println("Invalid Field : "+e.getInvalidField());
						System.out.println("InvalidVale : "+e.getInvalidValue());
						System.out.println("Message : "+e.getMessage());
						break;
					}
					
					System.out.println("Enter Employee ID: ");
					int id = sc.nextInt();
					int flag = 0;
					for(int k=0; k<counter; k++) {
						if(employee[k].getId()==id) {
							System.out.println("Employee Already Exist!");
							flag = 1;
						}
					}
					
					if(flag==1) {
						break;
					}
					
					sc.nextLine();
					System.out.println("Enter Employee Department: ");
					String dept = sc.nextLine();
					
					System.out.println("Enter Empoyee Salary");
					double sal = sc.nextDouble();
					
					
					System.out.println("Enter Employee : ");
					int jday = sc.nextInt();
					int jmonth = sc.nextInt();
					int jyear = sc.nextInt();
					try{
						employee[counter].dateOfJoining = new MyDate(jday,jmonth,jyear);
					} catch(InvalidDateException e) {
						System.out.println("Invalid Field : "+e.getInvalidField());
						System.out.println("InvalidVale : "+e.getInvalidValue());
						System.out.println("Message : "+e.getMessage());
						break;
					}
					
					employee[counter] = new Employee(name,id,dept,sal);
					counter++;
					break;
					
				case DISPLAY_ALL_EMP:
					for(int l=0; l<counter; l++) {
						System.out.println("Name: "+employee[l].getName());
						System.out.println("DOB: "+employee[l].dateOfBirth.toString());
						System.out.println("ID: "+employee[l].getId());
						System.out.println("Department: "+employee[l].getDepartment());
						System.out.println("Salary: "+employee[l].getSalary());
						System.out.println("Joined Date: "+employee[l].dateOfJoining.toString());
					}
					
				case SEARCH_EMP_BY_ID:
					System.out.println("Enter ID to be searched: ");
					int emp_id = sc.nextInt();
					
					for(int l=0; l<counter; l++) {
						if(employee[l].getId()==emp_id) {
							System.out.println(l+" .");
							System.out.println("Name: "+employee[l].getName());
							System.out.println("DOB: "+employee[l].dateOfBirth.toString());
							System.out.println("ID: "+employee[l].getId());
							System.out.println("Department: "+employee[l].getDepartment());
							System.out.println("Salary: "+employee[l].getSalary());
							System.out.println("Joined Date: "+employee[l].dateOfJoining.toString());
							System.out.println("--------------------");
						} else {
							System.out.println("Employee not Found!");
						}
					}
					
				case DISPLAY_EMP_JOIN_YEAR:
					
			}
		}
	}
}
