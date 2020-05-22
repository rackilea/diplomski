import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

File fXmlFile = new File("file.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
NodeList nList = doc.getElementsByTagName("student");

    System.out.println("----------------------------");
List studentList = new ArrayList();
    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;
             studentId = eElement.getAttribute("id"));
            //In above we will get studentID one by one . you can add         into one list and finally check expected studentid is present or not.
             studentList.add(studentId);
          }
}