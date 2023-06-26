package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.OrderLogMongoAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IOrderLogEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IOrderLogMongoRepository;
import com.pragma.powerup.usermicroservice.domain.api.IOrderLogServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IOrderLogPersistencePort;
import com.pragma.powerup.usermicroservice.domain.usecase.OrderLogUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IOrderLogMongoRepository orderLogMongoRepository;
    private final IOrderLogEntityMapper orderLogEntityMapper;

    @Bean
    public IOrderLogPersistencePort orderLogPersistencePort(){
        return new OrderLogMongoAdapter(orderLogMongoRepository, orderLogEntityMapper);
    }

    @Bean
    public IOrderLogServicePort orderLogServicePort(){
        return new OrderLogUseCase(orderLogPersistencePort());
    }

}
