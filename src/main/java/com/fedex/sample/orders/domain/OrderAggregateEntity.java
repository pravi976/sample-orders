package com.fedex.sample.orders.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Entity
public class OrderAggregateEntity {
    @Id
    private UUID id;
    private String orderNumber;
    private String customerTier;
    private String destinationPostalCode;
    private BigDecimal declaredValue;
    private Instant createdAt;

    @ElementCollection
    private Map<String, String> attributes = new LinkedHashMap<>();

    protected OrderAggregateEntity() {
    }

    public OrderAggregateEntity(UUID id, String orderNumber, String customerTier, String destinationPostalCode, BigDecimal declaredValue, Instant createdAt) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerTier = customerTier;
        this.destinationPostalCode = destinationPostalCode;
        this.declaredValue = declaredValue;
        this.createdAt = createdAt;
        this.attributes.put("channel", "web");
        this.attributes.put("priority", "expedited");
    }
}