package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillApp {

public static void main(String[] args) {

    try {
        Process pr = Runtime.getRuntime().exec("pidof chrome");
        BufferedReader read = new BufferedReader(new InputStreamReader(
                pr.getInputStream()));
        String str = read.readLine();
        System.out.println("Process id(s) to kill: " + str);
        pr = Runtime.getRuntime().exec("kill -9 " + str);
        System.out.println("done");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}