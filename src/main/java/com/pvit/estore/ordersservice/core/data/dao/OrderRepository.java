package com.pvit.estore.ordersservice.core.data.dao;

import com.pvit.estore.ordersservice.core.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

    Order findByOrderId(String orderId);

}
