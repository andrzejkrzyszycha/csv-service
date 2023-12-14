package com.example.csv.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Stock {

    private Date date;
    private Integer quantity;
    private String product;
    private String price;
    private String currency;

}
