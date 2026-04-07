package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;
import com.fedex.cdc.automation.annotations.PactSecret;

import java.util.Map;
import java.util.UUID;

public record InventoryReservationRequestExpectation(
        @PactExample("ORD-2026-00042") String orderNumber,
        @PactExample("CUST-GOLD-77") String customerReference,
        UUID requestId,
        ReservationLineExpectation line,
        WarehouseRoutingExpectation routingPreference,
        Map<String, String> fulfillmentAttributes,
        @PactSecret String fraudReviewToken) {
}