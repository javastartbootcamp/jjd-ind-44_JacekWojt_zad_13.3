package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Utils {

    public static Map<String, BigDecimal> createCurrenciesMap(String currenciesFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(currenciesFile));
        int lines = countLines(currenciesFile);
        Map<String, BigDecimal> currencies = new TreeMap<>();
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            BigDecimal number = BigDecimal.valueOf(Double.parseDouble(split[1]));
            currencies.put(split[0], number);
        }
        return currencies;
    }

    public static Products[] createProductsArray(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = countLines(fileName);
        Products[] products = new Products[lines];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(split[1]));
            products[i] = new Products(split[0], price, split[2]);
        }
        return products;
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        return lines;
    }
}
