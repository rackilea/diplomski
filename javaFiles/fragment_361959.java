package com.daniel.test;

import java.io.IOException;

public class Test {

public static void main(String[] args) throws Exception{
    Exception e = new Exception("Exception");
    IOException ioE = new IOException("An exception cause");
    e.initCause(ioE);
    throw e;
    }

}