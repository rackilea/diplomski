#!/usr/bin/env groovy

class ExampleClass {

    static void main(String[] args) {
        UtilClass util = new UtilClass()
        util.testPrint("Success!")
    }

}

class UtilClass {

    void testPrint(String text) {
        println(text)
    }

}