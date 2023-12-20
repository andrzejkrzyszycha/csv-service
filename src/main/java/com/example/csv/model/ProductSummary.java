package com.example.csv.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class ProductSummary implements Comparable<ProductSummary>{

    private String product;
    private Integer totalQuantity;
    private String currency;
    private BigDecimal value;

    @Override
    public int compareTo(ProductSummary o) {
        return this.getValue().compareTo(o.getValue());
    }
}
