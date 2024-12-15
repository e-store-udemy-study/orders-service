package com.pvit.estore.ordersservice.core.data;

import com.pvit.estore.ordersservice.core.constants.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = -7981200001411062522L;

    @Id
    @Column(unique = true)
    public String orderId;

    private String productId;

    private String userId;

    private int quantity;

    private String addressId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
