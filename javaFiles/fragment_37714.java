import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMBasicDoc {
    public static void main(String args[]) {
        try {
            String[] input = {"John Doe,123-456-7890", "Bob Smith,123-555-1212"};
            String[] line = new String[2];
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);
            Element memberList = doc.createElement("members");
            root.appendChild(memberList);
            for (int i = 0; i < input.length; i++) {
                line = input[i].split(",");
                Element member = doc.createElement("member");
                memberList.appendChild(member);
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(line[0]));
                member.appendChild(name);
                Element phone = doc.createElement("phone");
                phone.appendChild(doc.createTextNode(line[1]));
                member.appendChild(phone);
            }
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            System.out.println(writer.toString());

        } catch (TransformerException ex) {
            System.out.println("Error outputting document");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
    }
}