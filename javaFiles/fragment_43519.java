package com.util;
import java.net.URL;
public class AllNewsUpdatrUtility extends TimerTask {
       private static AllNewsUpdatrUtility instance;
       private final DocumentBuilderFactory dbf;
       private AllNewsUpdatrUtility() {}
       public synchronized static AllNewsUpdatrUtility getInstance() {
          if (instance == null)
             instance = new AllNewsUpdatrUtility();
             dbf = DocumentBuilderFactory.newInstance();
          return instance;
       }
    @Override
    public void run() {
         try {
             JSONArray latestnews = new JSONArray();
             JSONObject jsonobj_allnews = new JSONObject();
             DocumentBuilder builder = dbf.newDocumentBuilder();
             URL url = new URL("http://www.rssmix.com/u/8160628/rss.xml");
             Document doc = builder.parse(url.openStream());
             NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                String title = getValue(item, "title");
                String link = getValue(item, "link");
                String pub_date = getValue(item, "pubDate");

            } // for loop ends here 

          } catch (Exception e) {
             e.printStackTrace();
          }
    }


}