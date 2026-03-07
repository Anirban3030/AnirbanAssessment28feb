package com.ims.InventoryManagementSystem.dao;

import com.ims.InventoryManagementSystem.entity.Order;

public interface OrderDao {

    String saveOrder(Order order);

    String updateOrder(Order order);

    String deleteOrderById(int id);

    Order getOrderById(int id);
}
