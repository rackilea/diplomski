package com.example.resultsetupdate;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Book b = new Book(
                "WBIA", 
                "Why Bacon is Awesome", 
                java.math.BigDecimal.valueOf(1950, 2));
        BookDB bd;
        try {
            bd = new BookDB();
            bd.result.next();  // move to first row
            bd.updateRecord(b);
            bd.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

}