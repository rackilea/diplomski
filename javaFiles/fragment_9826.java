import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test {

    public static void main(String[] args) throws Exception {
        String rssUrl = ""; // paste url here
        List<RssDocument> docList = new ArrayList<RssDocument>();
        try
        {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(rssUrl);
            Element channel = (Element) document.getRootElement().element("channel");
            for (Iterator i = channel.elementIterator("item"); i.hasNext();)
            {
                Element element = (Element) i.next();
                String title = element.elementText("title");
                String pubDate = element.elementText("pubDate");
                String description = element.elementText("description");
                RssDocument doc = new RssDocument(title, pubDate, description);
                docList.add(doc);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // do something with docList
    }

    public static class RssDocument {
        String title;
        String pubDate;
        String description;

        RssDocument(String title, String pubDate, String description) {
            this.title = title;
            this.pubDate = pubDate;
            this.description = description;
        }
    }
}