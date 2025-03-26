package com.hookah.lounge.application;

import com.hookah.lounge.application.events.OrderEvent;
import com.hookah.lounge.application.events.OrderEventType;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    private final OrderService orderService;
    private final EventProcessor eventProcessor; // ✅ Now depends on an interface, not an integration component

    public OrderEventListener(OrderService orderService, EventProcessor eventProcessor) {
        this.orderService = orderService;
        this.eventProcessor = eventProcessor;
    }

    @EventListener
    public void handleOrderEvent(OrderEvent event) throws InterruptedException {
        System.out.println("🎤 Processing event: " + event.getEventType() + " for " + event.getCustomerName());

        orderService.processEvent(event); // ✅ Process event logic

        // ✅ Publish the next event via an interface (decoupled from the integration layer)
        switch (event.getEventType()) {
            case CUSTOMER_ENTERED -> eventProcessor.publishEvent(event.getCustomerName(), OrderEventType.HOOKAH_GUY_NOTICED);
            case HOOKAH_GUY_NOTICED -> eventProcessor.publishEvent(event.getCustomerName(), OrderEventType.HOOKAH_GUY_AT_TABLE);
            case HOOKAH_GUY_AT_TABLE -> eventProcessor.publishEvent(event.getCustomerName(), OrderEventType.ORDER_ACCEPTED);
            case ORDER_ACCEPTED -> eventProcessor.publishEvent(event.getCustomerName(), OrderEventType.ORDER_PLACED);
        }
    }
}
