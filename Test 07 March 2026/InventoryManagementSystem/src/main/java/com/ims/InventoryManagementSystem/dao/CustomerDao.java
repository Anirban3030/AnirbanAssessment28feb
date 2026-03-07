package com.ims.InventoryManagementSystem.dao;

import java.util.List;

import com.ims.InventoryManagementSystem.entity.Customer;

public interface CustomerDao {
	String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    String deleteCustomerById(int id);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(String email);
}



