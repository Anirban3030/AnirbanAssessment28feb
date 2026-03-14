package com.capgemini.spring_core.ems;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		System.out.println("sTartinG tHe EmS SySteM ...");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("empS");

		System.out.println();
		employeeService.addEmployee();
		System.out.println();

		employeeService.getEmployee();
		System.out.println();

		employeeService.updateEmployee();
		System.out.println();

		employeeService.deleteEmployee();

	}
}
