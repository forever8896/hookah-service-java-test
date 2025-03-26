package com.hookah.lounge.application;

import com.hookah.lounge.application.events.OrderEvent;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void processEvent(OrderEvent event) throws InterruptedException {
        String customerName = event.getCustomerName();
        System.out.println("📌 Handling event: " + event.getEventType() + " for " + customerName);

        switch (event.getEventType()) {
            case CUSTOMER_ENTERED -> {
                System.out.println("👀 Hookah guy noticed " + customerName + ".");
                Thread.sleep(2000);
            }
            case HOOKAH_GUY_NOTICED -> {
                System.out.println("👋 Hookah guy is approaching " + customerName + ".");
                Thread.sleep(3000);
            }
            case HOOKAH_GUY_AT_TABLE -> {
                System.out.println("✅ Hookah guy accepted the order for " + customerName + ".");
                Thread.sleep(1000);
            }
            case ORDER_ACCEPTED -> {
                System.out.println("🔥 Order placed! Starting hookah preparation for " + customerName + ".");
                Thread.sleep(5000);
            }
        }
    }
}
