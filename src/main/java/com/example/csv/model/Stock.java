package com.example.csv.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.*;

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
    @CsvBindByName(column = "Price", required = true)
    @CsvNumber("###.##")
    private BigDecimal price;
    @CsvBindByName(column = "Currency", required = true)
    private String currency;

}
