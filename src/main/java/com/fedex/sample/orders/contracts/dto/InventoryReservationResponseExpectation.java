package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;
import com.fedex.cdc.automation.annotations.PactSecret;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record InventoryReservationResponseExpectation(
        UUID reservationId,
        @PactExample("ORD-2026-00042") String orderNumber,
        @PactExample("CONFIRMED") String status,
        @PactExample("MEM-01") String allocatedWarehouse,
        @PactExample("PT30M") String expiresIn,
        ReservationLineExpectation allocatedLine,
        Map<String, String> audit,
        @PactSecret String reservationRiskToken,
        Instant expiresAt) {
}