package se.java.orderapi.repository;

import se.java.orderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Find orders by customer name
    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);

    // Find orders by product ID
    List<Order> findByProductId(Long productId);

    // Find orders by status
    List<Order> findByStatus(Order.OrderStatus status);
}