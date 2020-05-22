package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestJavaAppClean {

    public static void main(String[] args) {
        ProcessBuilder pb = null;
        Process p = null;
        BufferedReader br = null;

        try {
            String top = "C:\\Users\\MaxMueller\\Documents\\test\\";
            String cmd = "C:\\Python27\\python.exe";
            String arg = "deadparrot.py";
            pb = new ProcessBuilder(new String[]{cmd, top + arg});
            pb.directory(new File(top));
            p = pb.start();
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
            if (p != null) {
                p.destroy();
            }
        }
    }
}