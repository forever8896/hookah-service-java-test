package com.hookah.lounge.integration;

import com.hookah.lounge.business.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByCustomerNameIgnoreCase(String customerName);
}
