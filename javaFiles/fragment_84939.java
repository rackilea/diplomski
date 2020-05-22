package com.example.demo;

import java.time.*;

public class Period4th {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate july4 = LocalDate.of(2020, 6, 4);

        System.out.println(Duration.between(today.atStartOfDay(), july4.atStartOfDay()).toDays());

    }
}