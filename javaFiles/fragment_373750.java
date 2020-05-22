package com.stackoverflow.q3394298;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {

    public static void main(String... args) throws Exception {
        URL url = new URL("https://stackoverflow.com/questions/3394298/");
        Document document = Jsoup.connect(url).get();
        Element link = document.select("a.question-hyperlink").first();
        System.out.println(link.attr("href"));
        System.out.println(link.absUrl("href"));
    }

}