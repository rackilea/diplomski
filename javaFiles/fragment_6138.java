import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("humanFriends.xml");
        Document doc = builder.parse(file);

        NodeList humansL = doc.getElementsByTagName("humans");
        //System.out.println(humansL.getLength());
        for (int i = 0; i < humansL.getLength(); i++) {
            Node humansN = humansL.item(i);
            if (humansN.getNodeType() == Node.ELEMENT_NODE) {
                NodeList humanL = ((Element) humansN).getElementsByTagName("human");
                // System.out.println(humanL.getLength());
                for (int j = 0; j < humanL.getLength(); j++) {
                    Node humanN = humanL.item(j);
                    if (humanN.getNodeType() == Node.ELEMENT_NODE) {
                        Element humanE = (Element) humanN;
                        String name = humanE.getElementsByTagName("name").item(0).getTextContent();
                        String age= humanE.getElementsByTagName("age").item(0).getTextContent();
                        System.out.println(name);
                        System.out.println(age);
                    }
                }
            }
        }

        NodeList friendsL = doc.getElementsByTagName("friend");
        // System.out.println(friendsL.getLength());
        for (int i = 0; i < friendsL.getLength(); i++) {
            Node friendsN = friendsL.item(i);
            if (friendsN.getNodeType() == Node.ELEMENT_NODE) {
                NodeList friendL = ((Element) friendsN).getElementsByTagName("friends");
                // System.out.println(friendL.getLength());
                for (int j = 0; j < friendL.getLength(); j++) {
                    Node friendN = friendL.item(j);
                    if (friendN.getNodeType() == Node.ELEMENT_NODE) {
                        Element friendE = (Element) friendN;
                        String name = friendE.getElementsByTagName("name").item(0).getTextContent();
                        System.out.println(name);
                        String numberFriends = friendE.getElementsByTagName("numberFriends").item(0).getTextContent();
                        System.out.println(numberFriends);
                    }
                }
            }
        }
    }
}