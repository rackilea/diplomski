package xmlprocessing;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 *
 * @author z.benrhouma
 */
public class Main {

    public static void main(String... args) {

        try {
            Document document =  parse("src/main/resources/file.xml");
            Node node = document.selectSingleNode( "//Party/Contact/ContactInfo/Key[text()='keyTwo']/following-sibling::Value[1]");
            System.out.println(node.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static Document parse(String path) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
        return document;
    }
}