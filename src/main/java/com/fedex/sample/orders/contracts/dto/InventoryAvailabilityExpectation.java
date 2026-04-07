package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;
import com.fedex.cdc.automation.annotations.PactSecret;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record InventoryAvailabilityExpectation(
        @PactExample("SKU-LAPTOP-999") String sku,
        @PactExample("MEM-01") String warehouse,
        @PactExample("true") boolean reservable,
        UUID correlationId,
        InventoryQuantityExpectation quantity,
        WarehouseRoutingExpectation routing,
        MoneyExpectation replacementValue,
        Map<String, String> regionalStock,
        @PactSecret String internalRiskToken,
        Instant calculatedAt) {
}