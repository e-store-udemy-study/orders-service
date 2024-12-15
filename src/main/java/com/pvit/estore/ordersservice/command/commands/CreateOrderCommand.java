package com.pvit.estore.ordersservice.command.commands;

import com.pvit.estore.ordersservice.core.constants.OrderStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    private final String userId;

    private final String productId;

    private final int quantity;

    private final String addressId;

    private final OrderStatus orderStatus;
}
