package com.example.csv;

import com.example.csv.converter.ExchangeManager;
import com.example.csv.model.ProductSummary;
import com.example.csv.model.Stock;
import com.example.csv.report.Printer;
import com.example.csv.report.ReportGenerator;
import com.example.csv.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CsvApplication {

	public static void main(String[] args) {
		List<Stock> allStocks = new ArrayList<>();
		// Read all files
		Arrays.stream(args).parallel().forEach(f-> {
			List<Stock> stocks = FileUtil.readFile(f);
			allStocks.addAll(stocks);
		});

		ExchangeManager.convertToEUR(allStocks);

		Map<String, ProductSummary> report = ReportGenerator.generateSummaryReport(allStocks);

		Printer.print(report);

	}
}
