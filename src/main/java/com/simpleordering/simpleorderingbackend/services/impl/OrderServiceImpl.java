package com.simpleordering.simpleorderingbackend.services.impl;

import com.simpleordering.simpleorderingbackend.models.Order;
import com.simpleordering.simpleorderingbackend.repositories.OrderRepository;
import com.simpleordering.simpleorderingbackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order editOrder(int orderId, Order updatedOrder) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order existingOrder = orderOptional.get();
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setProduct(updatedOrder.getProduct());
            existingOrder.setAmount(updatedOrder.getAmount());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            return orderRepository.save(existingOrder);
        } else {
            return null; // Order with given ID not found
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
