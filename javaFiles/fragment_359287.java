package com.stackoverflow.answer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class HtmlParserExample {

    public static void main(String[] args) {
        String html = "<p class=\"outter\"><strong class=\"inner\">not needed message</strong>NEEDED MESSAGE</p>";
        Document doc = Jsoup.parse(html);
        Elements paragraphs = doc.select("p");
        for (Element p : paragraphs)
            System.out.println(p.ownText());
    }

}