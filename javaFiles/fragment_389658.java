import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

   public static void main(String argv[]) {
       final ArrayList<String> al=new ArrayList<String>();

    try {

    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {

    boolean bfname = false;
    boolean blname = false;
    boolean bnname = false;
    boolean bsalary = false;

    public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

        System.out.println("Start Element :" + qName);

        if (qName.equalsIgnoreCase("OBJECT_TYPE")) {
            bfname = true;
        }



    }

    public void endElement(String uri, String localName,
        String qName) throws SAXException {

        System.out.println("End Element :" + qName);

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bfname) {

            al.add(new String(ch, start, length));
            bfname = false;
        }



    }

     };

       saxParser.parse("C:\\Users\\Naren\\workspace\\Regex\\src\\test.xml", handler);
       System.out.println(al);

     } catch (Exception e) {
       e.printStackTrace();
     }

   }

}