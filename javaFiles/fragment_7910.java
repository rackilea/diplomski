package com.example;

@ProcessorStarterAnnotation
public class Main {
    public static void main(String[] args) {
      if ( com.example.Options.enablePrint ) {
        System.out.println(com.example.Options.textToPrint);
      }
      else {
        System.out.println("Print disabled");
      }
    }
}