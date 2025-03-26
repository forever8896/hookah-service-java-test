package com.hookah.lounge.application.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String customerName;
    private OrderEventType eventType;
    private LocalDateTime timestamp;

    public OrderEvent(String customerName, OrderEventType eventType) {
        this.customerName = customerName;
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }

    public OrderEventType getEventType() {
        return eventType;
    }
}
