package a.b.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static String NEW_LINE = System.getProperty("line.seprator");

    public static void main(String[] args) throws MalformedURLException, IOException {
        //URL of your service profile
        URL url = new URL("https://www.coinbase.com/charts");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //Connect to the website
        con.connect();
        //Open input stream to be able to read data
        InputStream inputStream = con.getInputStream();
        //wrap inputstream in buffer for better performance
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer contents = new StringBuffer();
        String line;
        //start reading the webpage response line by line
        while ((line = reader.readLine()) != null) {
            contents.append(line);
            contents.append(NEW_LINE);
        }
        inputStream.close();
        //print the webpage response for debugging, you may remove this line
        System.out.println(contents);

        //this is the element found just before the value in the page , i got it using inspect element in chrome
        String key = "1 BTC = $";
        //get the index of this above key that will return in the response
        int indexOf = contents.indexOf(key);
         //check if found
        if (indexOf != -1) {
            indexOf+=key.length();
            //get the exhange value based on this page response format
            String substring = contents.substring(indexOf, indexOf + 6);
            //print the exchange rate , of course you will need to parse it into double value
            System.out.println(substring);
        } else {
            System.out.println("Not found");
        }

    }

}