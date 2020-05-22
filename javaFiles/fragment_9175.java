package com;

import java.util.HashSet;
import java.util.Date;

public class Tester extends Thread
{
    HashSet<String> set = new HashSet<String>();

    public void run() {
        Date d = new Date();
        while (true) {
            try {
                if (set.size() > 0) {
                    d = new Date();
                    set.clear();
                }
                else {
                    if(new Date().getTime() - d.getTime() > 300000){
                        d = new Date();
                        //execute your method
                    }
                }

                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {
        try {
            Tester qT = new Tester();
            qT.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}