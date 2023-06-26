package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOrderLogEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOrderLogMongoRepository;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderLogPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderLogMongoAdapter implements IOrderLogPersistencePort {

    private final IOrderLogMongoRepository orderLogMongoRepository;
    private final IOrderLogEntityMapper orderLogEntityMapper;

    @Override
    public void saveOrderLog(OrderLog orderLog) {
        orderLogMongoRepository.save(orderLogEntityMapper.toEntity(orderLog));
    }

    @Override
    public List<OrderLog> getOrderLogsByOrderId(Long orderId) {
        return orderLogMongoRepository.findByOrderId(orderId);
    }
}
