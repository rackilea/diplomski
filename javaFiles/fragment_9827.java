import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test {

    public static void main(String[] args) throws Exception {
        String rssUrl = ""; // paste url here
        List<String> strList = new ArrayList<String>();
        try
        {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(rssUrl);
            Element channel = (Element) document.getRootElement().element("channel");
            for (Iterator i = channel.elementIterator("item"); i.hasNext();)
            {
                Element element = (Element) i.next();
                String title = element.elementText("title").replaceAll("\\<.*?>","");
                String description = element.elementText("description").replaceAll("\\<.*?>","");
                strList.add(title + " " + description);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}