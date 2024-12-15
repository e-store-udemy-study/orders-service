package com.pvit.estore.ordersservice.core.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private final Date timestamp;
    private final String message;
}
