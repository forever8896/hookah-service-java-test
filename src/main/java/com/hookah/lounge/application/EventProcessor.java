package com.hookah.lounge.application;

import com.hookah.lounge.application.events.OrderEventType;

public interface EventProcessor {
    void publishEvent(String customerName, OrderEventType eventType);
}
