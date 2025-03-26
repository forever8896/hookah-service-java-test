package com.hookah.lounge.interaction;

import com.hookah.lounge.application.EventProcessor;
import com.hookah.lounge.application.events.OrderEventType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final EventProcessor eventProcessor;

    public OrderController(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @PostMapping("/enter")
    public String customerEnters(@RequestParam String customerName) {
        eventProcessor.publishEvent(customerName, OrderEventType.CUSTOMER_ENTERED);
        return "🚪 " + customerName + " has entered the lounge.";
    }
}
