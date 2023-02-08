package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Calculator {

    public static BigDecimal totalInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal totalInEuro = BigDecimal.ZERO;
        for (Products product : products) {
            totalInEuro = totalInEuro.add(product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP));
        }
        return totalInEuro;
    }

    public static BigDecimal averageInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal totalInEuro = BigDecimal.ZERO;
        for (Products product : products) {
            totalInEuro = totalInEuro.add(product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP));
        }
        return totalInEuro.divide(BigDecimal.valueOf(products.length), 2, RoundingMode.HALF_UP);
    }

    public static String maxInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal maxInEuro = products[0].getPrice().divide(currencies.get(products[0].getCurrencyAbv()), 2, RoundingMode.HALF_UP);
        String productName = products[0].getProductName();
        for (Products product : products) {
            if (product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP).compareTo(maxInEuro) > 0) {
                maxInEuro = product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP);
                productName = product.getProductName();
            }
        }
        return productName;
    }

    public static String minInEuro(Products[] products, Map<String, BigDecimal> currencies) {
        BigDecimal minInEuro = products[0].getPrice().divide(currencies.get(products[0].getCurrencyAbv()), 2, RoundingMode.HALF_UP);
        String productName = products[0].getProductName();
        for (Products product : products) {
            if (product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP).compareTo(minInEuro) < 0) {
                minInEuro = product.getPrice().divide(currencies.get(product.getCurrencyAbv()), 2, RoundingMode.HALF_UP);
                productName = product.getProductName();
            }
        }
        return productName;
    }
}
