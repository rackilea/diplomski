package so;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

    private int getWebPageStatus(String url) {

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) new URL(url).openConnection();
            return con.getResponseCode();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        HttpRequest request = new HttpRequest();

        System.out.println("https://login.yahoo.com  :" + request.getWebPageStatus("https://login.yahoo.com"));
        System.out.println("https://www.google.co.in :" + request.getWebPageStatus("https://www.google.co.in"));
        System.out.println("https://www.gmail.com    :" + request.getWebPageStatus("https://www.gmail.com"));
        System.out.println("https://xyz.co.in        :" + request.getWebPageStatus("https://xyz.co.in"));
    }

}