package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;

public record InventoryQuantityExpectation(
        @PactExample("25") int onHand,
        @PactExample("18") int available,
        @PactExample("7") int reserved,
        @PactExample("3") int backorderThreshold) {
}