package com.example.csv.report;

import com.example.csv.model.ProductSummary;

import java.math.RoundingMode;
import java.util.Map;

public class Printer {

    public static void print(Map<String, ProductSummary> report){

        System.out.printf("%-20s %15s %15s %15s%n", "Product", "Total Quantity", "Currency", "Value");

        for(ProductSummary key : report.values()){
            System.out.printf("%-20s %15s %15s %15s%n", key.getProduct(),
                    key.getTotalQuantity(), key.getCurrency(), key.getValue().setScale(2, RoundingMode.HALF_EVEN));
        }
    }
}
