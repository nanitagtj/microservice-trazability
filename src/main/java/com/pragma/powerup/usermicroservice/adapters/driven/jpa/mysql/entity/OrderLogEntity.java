package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document(collection = "order_log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLogEntity {
    @MongoId
    private String id;
    private Long orderId;
    private String previousStatus;
    private String newStatus;
    private LocalDateTime timestamp;
}
