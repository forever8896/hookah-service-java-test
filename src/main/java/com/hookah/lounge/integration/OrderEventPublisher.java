package com.hookah.lounge.integration;

import com.hookah.lounge.application.EventProcessor;
import com.hookah.lounge.application.events.OrderEvent;
import com.hookah.lounge.application.events.OrderEventType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderEventPublisher implements EventProcessor { // ✅ Implements EventProcessor
    private final ApplicationEventPublisher eventPublisher;

    public OrderEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishEvent(String customerName, OrderEventType eventType) { // ✅ Implements interface
        OrderEvent event = new OrderEvent(customerName, eventType, LocalDateTime.now());
        eventPublisher.publishEvent(event);
        System.out.println("📢 Event Published: " + eventType + " for " + customerName);
    }
}
