package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;

public record ReservationLineExpectation(
        @PactExample("SKU-LAPTOP-999") String sku,
        @PactExample("2") int quantity,
        @PactExample("SERIALIZED") String inventoryClass,
        MoneyExpectation declaredValue) {
}