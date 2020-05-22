package com.jalalkiswani.stackoverflow.answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://www.google.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        InputStream inputStream = con.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer contents = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            contents.append(line);
            contents.append(NEW_LINE);
        }
        inputStream.close();
        System.out.println(contents);

    }
}