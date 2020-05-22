import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

public class XML {
    public static void main(String[] args) {
        XML xml = new XML();
        xml.makeFile();
    }

    public void makeFile() {
        Node item = null;
        Document xmlDoc = new DocumentImpl();
        Element root = xmlDoc.createElement("booking");
        item = xmlDoc.createElement("bookingID");
        item.appendChild(xmlDoc.createTextNode("115"));
        root.appendChild(item);
        xmlDoc.appendChild(root);

        try {
            Source source = new DOMSource(xmlDoc);
            File xmlFile = new File("yourFile.xml");
            StreamResult result = new StreamResult(new OutputStreamWriter(
                                  new FileOutputStream(xmlFile), "ISO-8859-1"));
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}