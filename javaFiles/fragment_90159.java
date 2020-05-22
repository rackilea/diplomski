package com.debug;

import java.io.IOException;

public class DebugMain {

    public static void main(String[] args) {
        fixCases();
    }

    public static void fixCases() {
        String filePath = System.getProperty("user.home").replace("\\", "/") + "/Documents/";
        String fileName = "case.txt";
        System.out.println("Organizing cases: " + filePath + fileName);

        CaseHandler ch = new CaseHandler(filePath + fileName, CaseType.Integer);
        try {
            ch.readFile();
            ch.sortCases();
            ch.writeCases(filePath + "casetest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Organizing complete.");
    }
}