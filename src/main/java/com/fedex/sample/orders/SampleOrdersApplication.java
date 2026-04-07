package com.fedex.sample.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fedex.sample.orders", "com.fedex.cdc"})
public class SampleOrdersApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleOrdersApplication.class, args);
    }
}