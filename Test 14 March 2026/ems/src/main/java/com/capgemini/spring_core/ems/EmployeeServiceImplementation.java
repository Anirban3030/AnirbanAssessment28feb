package com.capgemini.spring_core.ems;

public class EmployeeServiceImplementation implements EmployeeService {

	private Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Add employee");
		System.out.println(employee.toString());

	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Update Employee");
		System.out.println("Updating employee: " + employee.getName());

	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Delete Employee");
		System.out.println("Deleting employee with ID: " + employee.getId());

	}

	@Override
	public void getEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Get Employee");
		System.out.println(employee.toString());

	}

}
