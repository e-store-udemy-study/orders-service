package com.pvit.estore.ordersservice.core.events;

import com.pvit.estore.ordersservice.core.constants.OrderStatus;
import lombok.Value;

@Value
public class OrderApprovedEvent {

    String orderId;
    OrderStatus orderStatus = OrderStatus.APPROVED;
}
