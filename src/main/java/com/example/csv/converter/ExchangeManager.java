package com.example.csv.converter;

import com.example.csv.model.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ExchangeManager {

    public static final BigDecimal DUMMY_CONVERSION_RATE = BigDecimal.valueOf(1.2);

    public static void convert(List<Stock> stocks, String currency){
        stocks.forEach(stock -> {
            if(!stock.getCurrency().equals(currency)) {
                stock.setPrice(stock.getPrice().setScale(2, RoundingMode.HALF_UP)
                        .multiply(DUMMY_CONVERSION_RATE));
                stock.setCurrency(currency);
            }
        });
    }
}
