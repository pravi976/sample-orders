package com.fedex.sample.orders.contracts.dto;

import com.fedex.cdc.automation.annotations.PactExample;

import java.util.Map;

public record WarehouseRoutingExpectation(
        @PactExample("MEM-01") String primaryWarehouse,
        @PactExample("MEM-02") String backupWarehouse,
        @PactExample("FEDEX_2DAY") String shippingService,
        Map<String, String> routingTags) {
}