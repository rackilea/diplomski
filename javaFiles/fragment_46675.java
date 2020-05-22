import org.w3c.dom.*;
import org.xml.sax.*;
import java.text.*;
import java.util.*;
import javax.xml.parsers.*;
import java.io.*;
import com.google.common.base.*;
import com.google.common.io.*;

public class Test {

    public static void main(String[] args) throws Exception {
        String xml = Files.toString(new File("test.xml"), Charsets.UTF_8);
        Node node = getAuthToken(xml);
        System.out.println(node.getTextContent());
    }

    private static Node getAuthToken(String xml) throws Exception {
        Document doc = getXMLFromString(xml);
        NodeList authTokenNodeList = doc.getElementsByTagName("authToken");
        return authTokenNodeList.item(0);
    }

    public static Document getXMLFromString(String xml) throws Exception {
        Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory
            .newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        doc = builder.parse(new InputSource(new StringReader(xml)));
        return doc;
    }
}