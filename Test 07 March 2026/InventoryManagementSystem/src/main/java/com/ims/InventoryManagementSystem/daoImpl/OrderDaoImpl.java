package com.ims.InventoryManagementSystem.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ims.InventoryManagementSystem.dao.OrderDao;
import com.ims.InventoryManagementSystem.entity.Order;

public class OrderDaoImpl implements OrderDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("IMS01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String saveOrder(Order order) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(order);

		entityTransaction.commit();

		return "Order Saved Successfully";
	}

	@Override
	public String updateOrder(Order order) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.merge(order);

		entityTransaction.commit();

		return "Order Updated Successfully";
	}

	@Override
	public String deleteOrderById(int id) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Order order = entityManager.find(Order.class, id);

		if (order != null) {
			entityManager.remove(order);
			entityTransaction.commit();
			return "Order Deleted Successfully";
		} else {
			entityTransaction.rollback();
			return "Order Not Found";
		}
	}

	@Override
	public Order getOrderById(int id) {

		Order order = entityManager.find(Order.class, id);

		if (order != null) {
			return order;
		} else {
			return null;
		}
	}

}