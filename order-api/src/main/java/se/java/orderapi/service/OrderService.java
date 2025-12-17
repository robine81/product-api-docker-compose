package se.java.orderapi.service;

import se.java.orderapi.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    List<Order> getOrdersByCustomerName(String customerName);

    List<Order> getOrdersByProductId(Long productId);

    List<Order> getOrdersByStatus(Order.OrderStatus status);

    Order updateOrderStatus(Long id, Order.OrderStatus status);

    void deleteOrder(Long id);

    boolean testDatabaseConnection();
}