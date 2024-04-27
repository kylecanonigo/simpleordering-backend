package com.simpleordering.simpleorderingbackend.services;

import com.simpleordering.simpleorderingbackend.models.Customer;
import com.simpleordering.simpleorderingbackend.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int orderId);
    Order createOrder(Order order);
    Order editOrder(int orderId, Order order);
    void deleteOrder(int orderId);
}
