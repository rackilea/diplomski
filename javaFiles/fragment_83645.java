import java.io.IOException;
 import java.io.StringReader;

 import org.xmlpull.v1.XmlPullParser;
 import org.xmlpull.v1.XmlPullParserException.html;
 import org.xmlpull.v1.XmlPullParserFactory;

 public class SimpleXmlPullApp
 {

     public static void main (String args[])
         throws XmlPullParserException, IOException
     {
         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();

         xpp.setInput(new StringReader ("<foo>Hello World!</foo>"));
         int eventType = xpp.getEventType();
         while (eventType != XmlPullParser.END_DOCUMENT) {
          if(eventType == XmlPullParser.START_DOCUMENT) {
              System.out.println("Start document");
          } else if(eventType == XmlPullParser.END_DOCUMENT) {
              System.out.println("End document");
          } else if(eventType == XmlPullParser.START_TAG) {
              System.out.println("Start tag "+xpp.getName());
          } else if(eventType == XmlPullParser.END_TAG) {
              System.out.println("End tag "+xpp.getName());
          } else if(eventType == XmlPullParser.TEXT) {
              System.out.println("Text "+xpp.getText());
          }
          eventType = xpp.next();
         }
     }
 }