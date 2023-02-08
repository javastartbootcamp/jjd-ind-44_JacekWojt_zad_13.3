package pl.javastart.task;

import java.math.BigDecimal;

public class Products {
    private String productName;
    private BigDecimal price;
    private String currencyAbv;

    public Products(String productName, BigDecimal price, String currencyAbv) {
        this.productName = productName;
        this.price = price;
        this.currencyAbv = currencyAbv;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrencyAbv() {
        return currencyAbv;
    }
}
