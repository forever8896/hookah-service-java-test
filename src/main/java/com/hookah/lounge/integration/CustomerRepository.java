package com.hookah.lounge.integration;

import com.hookah.lounge.business.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCustomerNameIgnoreCase(String customerName);
}
