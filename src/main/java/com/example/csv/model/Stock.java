package com.example.csv.model;

import com.opencsv.bean.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Stock {

    @CsvBindByName(column = "Date", required = true)
    @CsvDate("dd/MM/yyyy")
    private Date date;
    @CsvBindByName(column = "Quantity", required = true)
    @CsvNumber("###")
    private Integer quantity;
    @CsvBindByName(column = "Product", required = true)
    private String product;
    @CsvBindByName(column = "Price", locale = "en-UK", required = true)
    @CsvNumber("###.##")
    private BigDecimal price;
    @CsvBindByName(column = "Currency", required = true)
    private String currency;

}
