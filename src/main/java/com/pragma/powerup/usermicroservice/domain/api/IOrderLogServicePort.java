package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.OrderLog;

import java.time.Duration;
import java.util.List;

public interface IOrderLogServicePort {

    void saveOrderLog(String orderLog);

    List<OrderLog> getOrderLogsByOrderId(Long orderId);
    Duration calculateElapsedTimeByOrderId(Long orderId);
}
