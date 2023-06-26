package com.pragma.powerup.usermicroservice.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;

public class Services {

    public static OrderLog deserializeFromJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.readValue(json, OrderLog.class);
        } catch (JsonProcessingException e) {
            System.err.println("Hubo un error al deserializar JSON a Object: " + e.getMessage());
            return null;
        }
    }
}
