package com.ims.InventoryManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.ims.InventoryManagementSystem.daoImpl.CustomerDaoImpl;
import com.ims.InventoryManagementSystem.daoImpl.OrderDaoImpl;
import com.ims.InventoryManagementSystem.entity.Customer;
import com.ims.InventoryManagementSystem.entity.Order;

public class ImsController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		OrderDaoImpl orderDao = new OrderDaoImpl();

		while (true) {

			System.out.println("\n Inventory Management System ");
			System.out.println("1. Insert Customer with Order");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer by Id");
			System.out.println("4. Fetch Customer by Id");
			System.out.println("5. Fetch All Customers");
			System.out.println("6. Fetch Customer by Email (JPQL)");
			System.out.println("7. Update Order");
			System.out.println("8. Fetch Order by Id");
			System.out.println("9. Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				Customer customer = new Customer();

				System.out.print("Enter Customer Name: ");
				customer.setCustomerName(sc.next());

				System.out.print("Enter Email: ");
				customer.setEmail(sc.next());

				System.out.print("Enter Gender: ");
				customer.setGender(sc.next());

				System.out.print("Enter Phone: ");
				customer.setPhone(sc.nextLong());

				customer.setRegistrationDate(LocalDate.now());

				Order order = new Order();

				System.out.print("Enter Order Number: ");
				order.setOrderNumber(sc.next());

				System.out.print("Enter Product Name: ");
				order.setProductName(sc.next());

				System.out.print("Enter Quantity: ");
				order.setQuantity(sc.nextInt());

				System.out.print("Enter Price: ");
				order.setPrice(sc.nextDouble());

				order.setOrderDate(LocalDate.now());

				order.setCustomer(customer);
				customer.setOrder(order);

				System.out.println(customerDao.saveCustomer(customer));

				break;

			case 2:

				System.out.print("Enter Customer Id to Update: ");
				int uId = sc.nextInt();

				Customer updateCustomer = customerDao.getCustomerById(uId);

				if (updateCustomer != null) {

					System.out.print("Enter New Name: ");
					updateCustomer.setCustomerName(sc.next());

					System.out.print("Enter New Phone: ");
					updateCustomer.setPhone(sc.nextLong());

					System.out.println(customerDao.updateCustomer(updateCustomer));

				} else {
					System.out.println("Customer Not Found");
				}

				break;

			case 3:

				System.out.print("Enter Customer Id to Delete: ");
				int delId = sc.nextInt();

				System.out.println(customerDao.deleteCustomerById(delId));

				break;

			case 4:

				System.out.print("Enter Customer Id: ");
				int id = sc.nextInt();

				Customer customerById = customerDao.getCustomerById(id);

				if (customerById != null) {
					System.out.println(customerById);
				} else {
					System.out.println("Customer Not Found");
				}

				break;

			case 5:

				List<Customer> customers = customerDao.getAllCustomers();

				for (Customer c : customers) {
					System.out.println(c);
				}

				break;

			case 6:

				System.out.print("Enter Email: ");
				String email = sc.next();

				Customer customer1 = customerDao.getCustomerByEmail(email);

				System.out.println(customer1);

				break;

			case 7:

				System.out.print("Enter OrderId to Update: ");
				int oId = sc.nextInt();

				Order oUpdate = orderDao.getOrderById(oId);

				if (oUpdate != null) {

					System.out.print("Enter New Product Name: ");
					oUpdate.setProductName(sc.next());

					System.out.print("Enter New Price: ");
					oUpdate.setPrice(sc.nextDouble());

					System.out.println(orderDao.updateOrder(oUpdate));

				} else {
					System.out.println("Order Not Found");
				}

				break;

			case 8:

				System.out.print("Enter Order Id: ");
				int fetchOId = sc.nextInt();

				Order fetched = orderDao.getOrderById(fetchOId);

				if (fetched != null) {
					System.out.println(fetched);
				} else {
					System.out.println("Order Not Found");
				}

				break;

			case 9:

				System.out.println("Exit");
				System.exit(0);

			default:
				System.out.println("Invalid Choice. choose correct choice");
			}

		}

	}
}