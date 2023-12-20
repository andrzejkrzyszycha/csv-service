package com.example.csv.util;

import com.example.csv.model.Stock;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    public static List<Stock> readAllFiles(String [] args) {
        List<Stock> allStocks = new ArrayList<>();
        Arrays.stream(args).parallel().forEach(f-> {
            List<Stock> stocks = readFile(f);
            allStocks.addAll(stocks);
        });
        return allStocks;
    }

    private static List<Stock> readFile(String fileName) {
        List<Stock> stocks = new ArrayList<>();
        try {
            stocks = new CsvToBeanBuilder<Stock>(new FileReader(fileName))
                    .withType(Stock.class)
                    .withSeparator(',')
                    .build()
                    .parse();
        } catch (FileNotFoundException e){
            System.out.println("File " + fileName + " not found !");
        }
        return stocks;
    }
}
