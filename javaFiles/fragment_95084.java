//package test;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Test {

    private static final String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
            + "<sentence>\n"
            + "    <one>  sentence one </one>\n"
            + "    <two> sentence two</two>\n"
            + "    <three> sentence three</three>   \n"
            + "    <four> sentence four </four>\n"
            + "    <five>  sentence five </five> \n"
            + "    <six> sentence six  </six> \n"
            + "    <seven> sentence seven </seven>\n"
            + "    <eight> sentence eight </eight>\n"
            + "    <nine>  sentence nine </nine>   \n"
            + "    <ten>   sentence ten  </ten>\n"
            + "</sentence>";

    public static void main(String[] args) throws IOException, SAXException {

        try {

            Map<String, String> hMap = new HashMap();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document doc = dBuilder.parse(is);

            Node node = doc.getElementsByTagName("sentence").item(0);
            String keys[] = {"one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten"};

            for (String kValue : keys) {
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    hMap.put(kValue, ((Element) node).getElementsByTagName(kValue).item(0).getTextContent());
                }
            }

            for (String key : keys) {
                System.out.println(hMap.get(key));
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}