package com.app.ems;
import java.util.Scanner;
import com.app.ems.classes.*;
import com.app.ems.classes.exceptions.InvalidDateException;

public class EmployeeManagementSystem{
	
	final static int MAX_EMPLOYEE_SIZE = 10;
	static int counter = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee[] employee = new Employee[MAX_EMPLOYEE_SIZE];
		
		enum Emp_Task{
			INVALID ,ADD_EMP, DISPLAY_ALL_EMP, SEARCH_EMP_BY_ID, DISPLAY_EMP_JOIN_YEAR, FIND_EMP_MAX_SALARY, FIND_EMP_MIN_SALARY, EXIT;
		}
		
		Emp_Task[] emp_task = Emp_Task.values();;
		
		while(true) {
			System.out.println("----------Welcome Employee Management System----------");
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
		
					System.out.println("REMAINING SIZE: "+(MAX_EMPLOYEE_SIZE-counter));
					
					if (counter>=MAX_EMPLOYEE_SIZE) {
                        System.out.println("Size full!");
                        break;
                    }
		
					sc.nextLine();
					System.out.println("Enter Employee Name:");
					String name = sc.nextLine();
					System.out.println("Enter Employee Date of Birth (dd-mm-yyyy): ");
					System.out.print("Enter day:");
					int day = sc.nextInt();
					System.out.print("Enter month:");
					int month = sc.nextInt();
					System.out.print("Enter year:");
					int year = sc.nextInt();
					MyDate dob;
					try{
						dob = new MyDate(day,month,year);
					} catch(InvalidDateException e) {
						System.out.println("Message : "+e.getMessage());
						break;
					}
					
					System.out.print("Enter Employee ID: ");
					int id = sc.nextInt();
					int flag = 0;
					for(int k=0; k<counter; k++) {
						if(employee[k].getId()==id) {
							System.out.println("Employee Already Exist!");
							flag = 1;
							break;
						}
					}
					
					if(flag==1) {
						break;
					}
					
					sc.nextLine();
					System.out.print("Enter Employee Department: ");
					String dept = sc.nextLine();
					
					System.out.print("Enter Empoyee Salary");
					double sal = sc.nextDouble();
					
					System.out.println("Enter Employee Date of Joining (dd-mm-yyyy): ");
					System.out.print("Enter day:");
					int jday = sc.nextInt();
					System.out.print("Enter month:");
					int jmonth = sc.nextInt();
					System.out.print("Enter year:");
					int jyear = sc.nextInt(); 
					MyDate doj;
					try{
						doj = new MyDate(jday,jmonth,jyear);
					} catch(InvalidDateException e) {
						System.out.println("Message : "+e.getMessage());
						break;
					}
					
					if(dob.getYear()>=doj.getYear()) {
						System.out.println("Birth date cant be greater than joining date!");
						break;
					}
					
					employee[counter] = new Employee(name,id,dept,sal,dob,doj);
					counter++;
					break;
					
				case DISPLAY_ALL_EMP:
					if(counter==0) {
						System.out.println("No employee found!");
					}
					
					for(int l=0; l<counter; l++) {
						System.out.println(l+" .");
						System.out.println("Name: "+employee[l].getName());
						System.out.println("DOB: "+employee[l].dateOfBirth.toString());
						System.out.println("ID: "+employee[l].getId());
						System.out.println("Department: "+employee[l].getDepartment());
						System.out.println("Salary: "+employee[l].getSalary());
						System.out.println("Joined Date: "+employee[l].dateOfJoining.toString());
						System.out.println("--------------------");
					}
					break;
					
				case SEARCH_EMP_BY_ID:
					System.out.print("Enter ID to be searched: ");
					int emp_id = sc.nextInt();
					boolean idFound = false;

					for(int l = 0; l < counter; l++) {
						if(employee[l].getId() == emp_id) {
							idFound = true;
							System.out.println(l + " .");
							System.out.println("Name: " + employee[l].getName());
							System.out.println("DOB: " + employee[l].dateOfBirth.toString());
							System.out.println("ID: " + employee[l].getId());
							System.out.println("Department: " + employee[l].getDepartment());
							System.out.println("Salary: " + employee[l].getSalary());
							System.out.println("Joined Date: " + employee[l].dateOfJoining.toString());
							System.out.println("--------------------");
							break;
						}
					}
					if (!idFound) {
						System.out.println("No employee found!");
					}
					break;

					
				case DISPLAY_EMP_JOIN_YEAR:
					System.out.print("Enter Year:  ");
					int emp_year = sc.nextInt();
					boolean yearFound = false;

					for(int l = 0; l < counter; l++) {
						if(employee[l].dateOfJoining.getYear() == emp_year) {
							yearFound = true;
							System.out.println(l + " .");
							System.out.println("Name: " + employee[l].getName());
							System.out.println("DOB: " + employee[l].dateOfBirth.toString());
							System.out.println("ID: " + employee[l].getId());
							System.out.println("Department: " + employee[l].getDepartment());
							System.out.println("Salary: " + employee[l].getSalary());
							System.out.println("Joined Date: " + employee[l].dateOfJoining.toString());
							System.out.println("--------------------");
						}
					}
					if (!yearFound) {
						System.out.println("No employee found! " + emp_year);
					}
					break;

					
				case FIND_EMP_MAX_SALARY:
					if(counter==0) {
						System.out.println("No employee found!");
						break;
					}
					
					double maxSalary=employee[0].getSalary();
					int maxIndex=0;
					
					for(int k=1; k<counter; k++) {
						if(employee[k].getSalary() > maxSalary) {
							maxSalary = employee[k].getSalary();
							maxIndex = k;
						}
					}
					
					System.out.println("Employee with MAXIMUM salary:");
					System.out.println("Name: "+employee[maxIndex].getName());
					System.out.println("Salary: "+employee[maxIndex].getSalary());
					System.out.println("ID: "+employee[maxIndex].getId());
					System.out.println("Department: "+employee[maxIndex].getDepartment());
					System.out.println("DOB: "+employee[maxIndex].dateOfBirth.toString());
					System.out.println("Joining Date: "+employee[maxIndex].dateOfJoining.toString());
					break;
					
				case FIND_EMP_MIN_SALARY:
					if(counter==0) {
						System.out.println("No employee found!");
						break;
					}
					
					double minSalary=employee[0].getSalary();
					int minIndex=0;
					
					for(int k=1; k<counter; k++) {
						if(employee[k].getSalary()<minSalary) {
							minSalary = employee[k].getSalary();
							minIndex = k;
						}
					}
					
					System.out.println("Employee with MINIMUM salary:");
					System.out.println("Name: "+employee[minIndex].getName());
					System.out.println("Salary: "+employee[minIndex].getSalary());
					System.out.println("ID: "+employee[minIndex].getId());
					System.out.println("Department: "+employee[minIndex].getDepartment());
					System.out.println("DOB: "+employee[minIndex].dateOfBirth.toString());
					System.out.println("Joining Date: "+employee[minIndex].dateOfJoining.toString());
					break;
					
				case EXIT:
					System.out.println("----------Exiting Employee Management System----------");
					System.exit(0);
					
					
				default:
					System.out.println("Invalid Choice");
					
			}
		}
	}
}
