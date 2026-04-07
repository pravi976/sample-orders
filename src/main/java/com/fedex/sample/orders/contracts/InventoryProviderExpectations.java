package com.fedex.sample.orders.contracts;

import com.fedex.cdc.automation.annotations.ConsumerPactClient;
import com.fedex.cdc.automation.annotations.ConsumerPactInteraction;
import com.fedex.sample.orders.contracts.dto.InventoryAvailabilityExpectation;
import com.fedex.sample.orders.contracts.dto.InventoryReservationRequestExpectation;
import com.fedex.sample.orders.contracts.dto.InventoryReservationResponseExpectation;
import org.springframework.stereotype.Component;

@Component
@ConsumerPactClient(consumer = "sample-orders", provider = "sample-inventory")
public class InventoryProviderExpectations {
    @ConsumerPactInteraction(
            description = "orders service expects complex SKU availability with routing and risk masking",
            providerState = "inventory item SKU-LAPTOP-999 exists with regional stock",
            method = "GET",
            path = "/api/inventory/sku/SKU-LAPTOP-999/availability",
            query = {"warehouse=MEM-01", "includeAlternates=true", "customerTier=GOLD"},
            responseBody = InventoryAvailabilityExpectation.class)
    public void readInventoryAvailability() {
    }

    @ConsumerPactInteraction(
            description = "orders service reserves serialized inventory with fulfillment metadata",
            providerState = "inventory reservation can be confirmed for order ORD-2026-00042",
            method = "POST",
            path = "/api/inventory/reservations",
            responseStatus = 201,
            requestBody = InventoryReservationRequestExpectation.class,
            responseBody = InventoryReservationResponseExpectation.class)
    public void reserveInventory() {
    }
}