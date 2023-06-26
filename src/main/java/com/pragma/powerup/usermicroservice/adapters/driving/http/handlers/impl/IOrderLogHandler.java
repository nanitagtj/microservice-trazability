package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.domain.model.OrderLog;

import java.util.List;

public interface IOrderLogHandler {

    void saveOrderLog(String orderLog);

    List<OrderLog> getOrderLogsByOrderId(Long orderId);
}
