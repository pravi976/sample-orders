package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;

import java.math.BigDecimal;

public record MoneyExpectation(
        @PactExample("1299.95") BigDecimal amount,
        @PactExample("USD") String currency) {
}