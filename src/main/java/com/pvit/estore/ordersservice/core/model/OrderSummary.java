package com.pvit.estore.ordersservice.core.model;

import com.pvit.estore.ordersservice.core.constants.OrderStatus;
import lombok.Value;

@Value
public class OrderSummary {

    String orderId;
    OrderStatus orderStatus;
    String message;
}
