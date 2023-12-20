package com.example.csv;

import com.example.csv.model.ProductSummary;
import com.example.csv.model.Stock;

import java.util.List;
import java.util.Map;

import static com.example.csv.report.Printer.print;
import static com.example.csv.report.ReportGenerator.generateSummaryReport;
import static com.example.csv.util.FileUtil.readAllFiles;

public class CsvApplication {

	public static void main(String[] args) {
		List<Stock> allStocks = readAllFiles(args);
		Map<String, ProductSummary> report = generateSummaryReport(allStocks, "EUR");
		print(report);
	}
}
