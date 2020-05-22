import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        // the connection (wrapped in a try-catch)
        Document jSoupDoc = Jsoup.connect("https://www.google.it/search?q=site:facebook.com+dog+daterange:2457328-2457342").userAgent("Mozilla/5.0").timeout(5000).get();

        // fetching the links
        Elements links = jSoupDoc.select("a[href]");
        Element link;
        for (int i = 0; i < links.size(); i++)
        {
            link = links.get(i);
            String temp = link.attr("href");

            // filtering the first 10 google links
            if (temp.contains("url") && !temp.contains("webcache"))
            {
                String[] splitTemp = temp.split("=");
                String[] splitTemp2 = splitTemp[1].split("&sa");
                System.out.println(splitTemp2[0]);
            }
        }
    }
}