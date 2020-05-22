package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/Input.txt");
            File outputFile = new File("src/Output.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader
                            (new FileInputStream(inputFile), "iso-8859-5"));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                            (new FileOutputStream(outputFile), "iso-8859-5"));

            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line + "\n");
            }

            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}