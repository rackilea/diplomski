import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class reader {
    public static String LookUpValues(String sb) throws Exception{  

        DocumentBuilder builder = DocumentBuilderFactory
                .newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(sb));

        Document doc = builder.parse(src);
        String value = doc.getElementsByTagName("tag4").item(0).getTextContent();

        return ("Value is: " + value);
    }
}