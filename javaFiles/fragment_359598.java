package yourPackage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        Document doc = factory.newDocumentBuilder().parse(Files.newInputStream(Paths.get("test.xml")));
        doc.getDocumentElement().normalize();

        Element data = (Element)doc.getElementsByTagName("IndexData").item(0);
        System.out.println(data.getAttribute("FileName"));
    }
}