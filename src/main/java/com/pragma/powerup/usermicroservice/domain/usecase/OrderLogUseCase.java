package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IOrderLogServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.NotFoundOrderLogsException;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderLogPersistencePort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.pragma.powerup.usermicroservice.domain.services.Services.deserializeFromJson;

public class OrderLogUseCase implements IOrderLogServicePort {
    private final IOrderLogPersistencePort orderLogPersistencePort;

    public OrderLogUseCase(IOrderLogPersistencePort orderLogPersistencePort) {
        this.orderLogPersistencePort = orderLogPersistencePort;
    }

    @Override
    public void saveOrderLog(String orderLog) {
        orderLogPersistencePort.saveOrderLog(deserializeFromJson(orderLog));
    }
    @Override
    public List<OrderLog> getOrderLogsByOrderId(Long orderId){
        return orderLogPersistencePort.getOrderLogsByOrderId(orderId);
    }
    @Override
    public Duration calculateElapsedTimeByOrderId(Long orderId) {
        List<OrderLog> orderLogs = orderLogPersistencePort.getOrderLogsByOrderId(orderId);
        if (orderLogs.isEmpty()) {
            throw new NotFoundOrderLogsException();
        }

        LocalDateTime startTimestamp = orderLogs.get(0).getTimestamp();
        LocalDateTime endTimestamp = orderLogs.get(orderLogs.size() - 1).getTimestamp();

        return Duration.between(startTimestamp, endTimestamp);
    }
}
