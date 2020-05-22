package com.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    public static void main (String args[]){
        Document doc;
        try {

            doc = Jsoup.connect("http://en.wikipedia.org/wiki/States_and_territories_of_India").get();
            Elements newsHeadlines = doc.select("table.wikitable").get(0).select("td:eq(0) a");

            System.out.println(newsHeadlines.html());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}