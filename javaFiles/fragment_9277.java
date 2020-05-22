// XmlTest.java

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlTest {
    public static void main(final String[] args) throws Exception {

        String xmlString = "<foo>\n"
                         + "    <bar>\n"
                         + "        <moo>Hello World!</moo>\n"
                         + "    </bar>\n"
                         + "</foo>";

        InputStream is = new ByteArrayInputStream(xmlString.getBytes());
        Document doc = PositionalXMLReader.readXML(is);
        is.close();

        Node node = doc.getElementsByTagName("moo").item(0);

        System.out.println("Line number: " + node.getUserData("lineNumber"));
    }
}