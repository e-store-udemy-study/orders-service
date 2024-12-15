package com.pvit.estore.ordersservice.query;

import com.pvit.estore.ordersservice.core.data.Order;
import com.pvit.estore.ordersservice.core.data.dao.OrderRepository;
import com.pvit.estore.ordersservice.core.model.OrderSummary;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class OrdersQueryHandler {

    private final OrderRepository orderRepository;

    public OrdersQueryHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryHandler
    public OrderSummary findOrder(FindOrdersQuery findOrdersQuery) {
        Order orderEntity = orderRepository.findByOrderId(findOrdersQuery.getOrderId());
        return new OrderSummary(orderEntity.getOrderId(),
                orderEntity.getOrderStatus(), "");
    }
}
