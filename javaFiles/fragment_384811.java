package com.github.davidepastore.stackoverflow34331254;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Reply to stackoverflow 34331254 question.
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String url = "http://www.htmlcodetutorial.com/tables/_THEAD.html";
        String fileName = "table.csv";
        FileWriter writer = new FileWriter(fileName);
        Document doc = Jsoup.connect(url).get();
        System.out.println(doc);
        Element tableElement = doc.select("table").first();

        Elements tableHeaderEles = tableElement.select("thead tr th");
        System.out.println("headers");
        for (int i = 0; i < tableHeaderEles.size(); i++) {
            System.out.println(tableHeaderEles.get(i).text());
            writer.append(tableHeaderEles.get(i).text());

            if(i != tableHeaderEles.size() -1){             
                writer.append(',');
            }
        }
        writer.append('\n');
        System.out.println();

        Elements tableRowElements = tableElement.select(":not(thead) tr");

        for (int i = 0; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            System.out.println("row");
            Elements rowItems = row.select("td");
            for (int j = 0; j < rowItems.size(); j++) {
                System.out.println(rowItems.get(j).text());
                writer.append(rowItems.get(j).text());

                if(j != rowItems.size() -1){
                    writer.append(',');
                }
            }
            writer.append('\n');
        }

        writer.close();
    }
}