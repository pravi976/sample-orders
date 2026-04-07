package com.fedex.sample.orders.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderAggregateRepository extends JpaRepository<OrderAggregateEntity, UUID> {
}