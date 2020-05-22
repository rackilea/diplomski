package com.example.resultsetupdate;

import java.math.BigDecimal;

public class Book {
    private String code;
    private String title;
    private BigDecimal price;

    public Book(String code, String title, BigDecimal price) {
        super();
        this.code = code;
        this.title = title;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}