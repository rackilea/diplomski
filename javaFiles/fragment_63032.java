package com.example.jdbc;

import java.sql.DriverManager;

public class Driver implements java.sql.Driver {
    static {
        DriverManager.registerDriver(new Driver());
    }

    // ...implementation...
}