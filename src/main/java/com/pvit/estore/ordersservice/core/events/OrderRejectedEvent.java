package com.pvit.estore.ordersservice.core.events;

import com.pvit.estore.ordersservice.core.constants.OrderStatus;
import lombok.Value;

@Value
public class OrderRejectedEvent {

    String orderId;
    String reason;
    OrderStatus orderStatus = OrderStatus.REJECTED;
}
