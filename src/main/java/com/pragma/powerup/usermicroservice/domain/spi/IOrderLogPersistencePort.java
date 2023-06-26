package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.OrderLog;

import java.util.List;

public interface IOrderLogPersistencePort {
    void saveOrderLog(OrderLog orderLog);

    List<OrderLog> getOrderLogsByOrderId(Long orderId);
}
