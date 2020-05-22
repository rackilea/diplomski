package com.stackoverflow.q3459127;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Test {

    public static void main(String... args) throws Exception {

        // Init.
        int bufferSize = 10240; // 10KB.
        int fileSize = 100 * 1024 * 1024; // 100MB.
        File file = new File("/temp.txt");

        // Create file (it's also a good JVM warmup).
        System.out.print("Creating file .. ");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < fileSize; i++) {
                writer.write("0");
            }
            System.out.printf("finished, file size: %d MB.%n", file.length() / 1024 / 1024);
        } finally {
            if (writer != null) try { writer.close(); } catch (IOException ignore) {}
        }

        // Read through funnel.
        System.out.print("Reading through funnel .. ");
        Reader r1 = null;        
        try {
            r1 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"), bufferSize);
            long st = System.nanoTime();
            for (int data; (data = r1.read()) > -1;);
            long et = System.nanoTime();
            System.out.printf("finished in %d ms.%n", (et - st) / 1000000);
        } finally {
            if (r1 != null) try { r1.close(); } catch (IOException ignore) {}
        }

        // Read through bottle.
        System.out.print("Reading through bottle .. ");
        Reader r2 = null;        
        try {
            r2 = new InputStreamReader(new BufferedInputStream(new FileInputStream(file), bufferSize), "UTF-8");
            long st = System.nanoTime();
            for (int data; (data = r2.read()) > -1;);
            long et = System.nanoTime();
            System.out.printf("finished in %d ms.%n", (et - st) / 1000000);
        } finally {
            if (r2 != null) try { r2.close(); } catch (IOException ignore) {}
        }

        // Cleanup.
        if (!file.delete()) System.err.printf("Oops, failed to delete %s. Cleanup yourself.%n", file.getAbsolutePath());
    }

}