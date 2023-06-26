package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.OrderLogEntity;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderLogMongoRepository extends MongoRepository<OrderLogEntity, String> {
    List<OrderLog> findByOrderId(Long orderId);
}
