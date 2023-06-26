package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.domain.api.IOrderLogServicePort;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLogHandlerImpl implements IOrderLogHandler{
    private final IOrderLogServicePort orderLogServicePort;
    @Override
    public void saveOrderLog(String orderLog) {
        orderLogServicePort.saveOrderLog(orderLog);
    }

    @Override
    public List<OrderLog> getOrderLogsByOrderId(Long orderId) {
        return orderLogServicePort.getOrderLogsByOrderId(orderId);
    }

    @Override
    public Duration calculateElapsedTimeByOrderId(Long orderId) {
        return orderLogServicePort.calculateElapsedTimeByOrderId(orderId);
    }

}
