package com.example.csv.converter;

import com.example.csv.model.Stock;

import java.math.BigDecimal;
import java.util.List;

public class ExchangeManager {

    public static final BigDecimal CHF_CONVERSION_RATE = BigDecimal.valueOf(1.2);
    public static final BigDecimal PLN_CONVERSION_RATE = BigDecimal.valueOf(0.9);

    public static void convertToEUR(List<Stock> stocks){
        stocks.forEach(stock -> {
            if(stock.getCurrency().equals("CHF")) {
                stock.setPrice(stock.getPrice().multiply(CHF_CONVERSION_RATE));
                stock.setCurrency("EUR");
            } else if (stock.getCurrency().equals("PLN")){
                stock.setPrice(stock.getPrice().multiply(PLN_CONVERSION_RATE));
                stock.setCurrency("EUR");
            }
        });
    }
}
