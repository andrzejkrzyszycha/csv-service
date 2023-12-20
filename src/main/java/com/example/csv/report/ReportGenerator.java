package com.example.csv.report;

import com.example.csv.converter.ExchangeManager;
import com.example.csv.model.ProductSummary;
import com.example.csv.model.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public static Map<String, ProductSummary> generateSummaryReport(List<Stock> allStocks, String currency) {

        Map<String, ProductSummary> summary = new HashMap<>();

        ExchangeManager.convert(allStocks, currency);

        allStocks.forEach(s -> {
            if(summary.containsKey(s.getProduct())){
                ProductSummary productSummary = summary.get(s.getProduct());
                productSummary.setValue(productSummary.getValue().add(s.getPrice()));
                productSummary.setTotalQuantity(productSummary.getTotalQuantity() + s.getQuantity());
                summary.put(s.getProduct(), productSummary);
            } else {
                summary.put(s.getProduct(), ProductSummary.builder()
                        .product(s.getProduct())
                        .currency(s.getCurrency())
                        .totalQuantity(s.getQuantity())
                        .value(s.getPrice())
                        .build());
            }
        });

        return summary;
    }
}
