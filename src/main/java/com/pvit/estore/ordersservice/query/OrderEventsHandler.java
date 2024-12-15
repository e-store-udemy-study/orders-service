package com.pvit.estore.ordersservice.query;

import com.pvit.estore.ordersservice.core.data.Order;
import com.pvit.estore.ordersservice.core.data.dao.OrderRepository;
import com.pvit.estore.ordersservice.core.events.OrderApprovedEvent;
import com.pvit.estore.ordersservice.core.events.OrderCreatedEvent;
import com.pvit.estore.ordersservice.core.events.OrderRejectedEvent;
import jakarta.persistence.EntityNotFoundException;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("order-group")
public class OrderEventsHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventsHandler.class);

    private final OrderRepository orderRepository;

    public OrderEventsHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }

    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();
        BeanUtils.copyProperties(event, order);
        try {
            orderRepository.save(order);
        } catch (Exception ex) {
            LOGGER.error("Error while saving order. Error: {}", ex.getMessage());
        }
    }

    @EventHandler
    public void on(OrderApprovedEvent orderApprovedEvent) {
        Order orderEntity = orderRepository.findByOrderId(orderApprovedEvent.getOrderId());

        if (orderEntity == null) {
            throw new EntityNotFoundException(String.format("Order with id %s not found", orderApprovedEvent.getOrderId()));
        }

        orderEntity.setOrderStatus(orderApprovedEvent.getOrderStatus());

        orderRepository.save(orderEntity);

    }

    @EventHandler
    public void on(OrderRejectedEvent orderRejectedEvent) {
        Order orderEntity = orderRepository.findByOrderId(orderRejectedEvent.getOrderId());
        orderEntity.setOrderStatus(orderRejectedEvent.getOrderStatus());
        orderRepository.save(orderEntity);
    }
}
