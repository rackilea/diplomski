import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.CharacterData;

public class LabFour {
    public static void main(String[] args) {
        DocumentBuilder dbf = null;
        Document doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(
                    new StringReader("<getResult><id>null</id><pdf>ioje98fh23fjkiwf72322342</pdf></getResult>"));
            doc = dbf.parse(is);

            NodeList nodes = doc.getElementsByTagName("getResult");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);

                NodeList name = element.getElementsByTagName("id");
                Element line = (Element) name.item(0);
                System.out.println("id: " + getCharacterDataFromElement(line));

                NodeList pdf = element.getElementsByTagName("pdf");
                line = (Element) title.item(0);
                System.out.println("pdf: " + getCharacterDataFromElement(pdf));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }

}