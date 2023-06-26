package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl.IOrderLogHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.model.OrderLog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.ORDER_CREATED_MESSAGE;

@RestController
@RequestMapping("/traceability")
@RequiredArgsConstructor
public class OrderLogController {

    private final IOrderLogHandler orderLogHandler;

    @Operation(summary = "Add a new orderLog",
            responses = {
                    @ApiResponse(responseCode = "201", description = "order log created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "order log already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/orderLog")
    public ResponseEntity<Map<String, String>> saveOrderLog(@RequestBody String orderLog) {
        orderLogHandler.saveOrderLog(orderLog);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, ORDER_CREATED_MESSAGE));
    }

    @Operation(summary = "Get order logs by order ID")
    @GetMapping("/orderLogs/{orderId}")
    public ResponseEntity<List<OrderLog>> getOrderLogsByOrderId(@PathVariable Long orderId) {
        List<OrderLog> orderLogs = orderLogHandler.getOrderLogsByOrderId(orderId);
        return ResponseEntity.ok(orderLogs);
    }
    @Operation(summary = "Calculate elapsed time by order ID")
    @GetMapping("/orderElapsedTime/{orderId}")
    public ResponseEntity<String> calculateElapsedTimeByOrderId(@PathVariable Long orderId) {
        String elapsedTime = String.valueOf(orderLogHandler.calculateElapsedTimeByOrderId(orderId));
        return ResponseEntity.ok(elapsedTime);
    }

}
