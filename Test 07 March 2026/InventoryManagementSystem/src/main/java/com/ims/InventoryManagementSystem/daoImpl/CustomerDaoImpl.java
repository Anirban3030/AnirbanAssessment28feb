package com.ims.InventoryManagementSystem.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ims.InventoryManagementSystem.dao.CustomerDao;
import com.ims.InventoryManagementSystem.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IMS01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String saveCustomer(Customer customer) {

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(customer);
		transaction.commit();

		return "Customer saved successfully";
	}

	@Override
	public String updateCustomer(Customer customer) {

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.merge(customer);
		transaction.commit();

		return "Customer updated successfully";
	}

	@Override
	public String deleteCustomerById(int id) {

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Customer customer = entityManager.find(Customer.class, id);

		if (customer != null) {
			entityManager.remove(customer);
			transaction.commit();
			return "Customer deleted successfully";
		} else {
			transaction.rollback();
			return "Customer not found";
		}
	}

	@Override
	public Customer getCustomerById(int id) {

		Customer customer = entityManager.find(Customer.class, id);

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {

		String query = "select c from Customer c";

		TypedQuery<Customer> queryexe = entityManager.createQuery(query, Customer.class);

		List<Customer> customerList = queryexe.getResultList();

		return customerList;
	}

	@Override
	public Customer getCustomerByEmail(String email) {

		String query = "select c from Customer c where c.email = :email";

		TypedQuery<Customer> queryexe = entityManager.createQuery(query, Customer.class);

		queryexe.setParameter("email", email);

		Customer customer = queryexe.getSingleResult();

		return customer;
	}

}