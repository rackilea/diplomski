package com.srijan.playground;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterLengthWords {

    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
             br = new BufferedReader(new FileReader("Sample.txt"));
             bw = new BufferedWriter(new FileWriter("Output.txt"));
             String tmp = null;
             while((tmp=br.readLine())!=null) {
                 if(tmp.length()<=9) {
                     bw.write(tmp);
                 }
             }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(br!=null) {
                br.close();
                br=null;
            }
            if(bw!=null){
                bw.close();
                bw=null;
            }
        }
    }
}