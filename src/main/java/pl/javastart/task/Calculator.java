package pl.javastart.task;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

public class Calculator {

    public static BigDecimal totalInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal totalInEuro = BigDecimal.ZERO;
        for (Products product : products) {
            totalInEuro = totalInEuro.add(product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64));
        }
        return totalInEuro;
    }

    public static BigDecimal averageInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal totalInEuro = BigDecimal.ZERO;
        for (Products product : products) {
            totalInEuro = totalInEuro.add(product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64));
        }
        return totalInEuro.divide(BigDecimal.valueOf(products.length), MathContext.DECIMAL64);
    }

    public static String maxInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal maxInEuro = products[0].getPrice().divide(currencies.get(products[0].getCurrencyAbv()), MathContext.DECIMAL64);
        String productName = products[0].getProductName();
        for (Products product : products) {
            if (product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64).compareTo(maxInEuro) == 1) {
                maxInEuro = product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64);
                productName = product.getProductName();
            }
        }
        return productName;
    }

    public static String minInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal minInEuro = products[0].getPrice().divide(currencies.get(products[0].getCurrencyAbv()), MathContext.DECIMAL64);
        String productName = products[0].getProductName();
        for (Products product : products) {
            if (product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64).compareTo(minInEuro) == -1) {
                minInEuro = product.getPrice().divide(currencies.get(product.getCurrencyAbv()), MathContext.DECIMAL64);
                productName = product.getProductName();
            }
        }
        return productName;
    }
}
