import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class CountNoOfElements{

    public static void main(String args[]) throws Exception {
        String filepath = "test.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        NodeList nodeList = doc.getElementsByTagName("*");
        int count = nodeList.getLength();
        System.out.println("Total of elements : " + count);
    }   
}