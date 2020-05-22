package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args)  {
        File file = new File("foobar.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rws");
            randomAccessFile.write(new byte[]{'f'});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile !=null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    //doh!
                }
            }
        }
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char read = (char) reader.read();
            System.out.println("what was written: "+read);
            System.out.println("file size: "+file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    //doh!
                }
            }
        }
    }
}