package pl.javastart.task;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String productsFile = "C:/JavaStartProjects/jjd-ind-44_JacekWojt_zad_13.3/src/main/resources/products.csv";
            Products[] products = Utils.createProductsArray(productsFile);
            String currenciesFile = "C:/JavaStartProjects/jjd-ind-44_JacekWojt_zad_13.3/src/main/resources/currencies.csv";
            Map<String, BigDecimal> currencies = Utils.createCurrenciesMap(currenciesFile);
            BigDecimal totalInEuro = Calculator.totalInEuro(products, currencies);
            System.out.printf("Suma wszystkich produktów w EUR: %.2f%n", totalInEuro.doubleValue());
            BigDecimal avgInEuro = Calculator.averageInEuro(products, currencies);
            System.out.printf("Średnia wartości produktu w EUR: %.2f%n", avgInEuro.doubleValue());
            String maxProductName = Calculator.maxInEuro(products, currencies);
            System.out.println("Najdroższy produkt w przeliczeniu na EUR to " + maxProductName);
            String minProductName = Calculator.minInEuro(products, currencies);
            System.out.println("Najtańszy produkt w przeliczeniu na EUR to " + minProductName);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku.");
        }
    }
}
