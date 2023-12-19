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
public class ProductSummary {

    private String product;
    private Integer totalQuantity;
    private String currency;
    private BigDecimal value;

}
