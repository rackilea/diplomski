package com.me.basiccalcws;

import javax.jws.WebService;

@WebService(targetNamespace = "http://client.basiccalcws.me.com/")
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}