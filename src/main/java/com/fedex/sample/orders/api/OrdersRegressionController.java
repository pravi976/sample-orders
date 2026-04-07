package com.fedex.sample.orders.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrdersRegressionController {
    @GetMapping("/inventory/sku/{sku}/availability")
    public Map<String, Object> inventoryExpectation(@PathVariable String sku,
                                                    @RequestParam String warehouse,
                                                    @RequestParam boolean includeAlternates,
                                                    @RequestParam String customerTier) {
        return Map.of(
                "sku", sku,
                "warehouse", warehouse,
                "available", true,
                "routing", Map.of(
                        "primaryWarehouse", warehouse,
                        "alternateWarehouse", includeAlternates ? "MEM-02" : warehouse,
                        "shippingMethod", "GOLD".equals(customerTier) ? "FEDEX_2DAY" : "GROUND"));
    }

    @PostMapping("/inventory/reservations")
    public ResponseEntity<Map<String, Object>> reserveInventory(@RequestBody Map<String, Object> request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "reservationId", "bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb",
                "orderNumber", request.get("orderNumber"),
                "status", "CONFIRMED",
                "warehouse", "MEM-01"));
    }
}
