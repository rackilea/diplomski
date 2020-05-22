import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            File fXmlFile = new File("D://test3.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList0 = doc.getElementsByTagName("Service");
            NodeList nodeList1 = doc.getElementsByTagName("File");
            NodeList nodeList2 = doc.getElementsByTagName("name");
            NodeList nodeList3 = doc.getElementsByTagName("grouped");
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            for (int temp0 = 0; temp0 < nodeList0.getLength(); temp0++) {
                Node node0 = nodeList0.item(temp0);
                System.out.println("\nElement type :" + node0.getNodeName());
                Element Service = (Element) node0;
                System.out.println("----" + temp0 + "-------");
                if (node0.getNodeType() == Node.ELEMENT_NODE) {
                    System.out
                    .println("Name : " + Service.getAttribute("name"));
                    System.out.println("regrx : "
                            + Service.getAttribute("regrx"));
                    System.out.println("reverex"
                            + Service.getAttribute("reverseExtention"));
                    for (int temp = 0; temp < nodeList1.getLength(); temp++) {
                        Node node1 = nodeList1.item(temp);
                        System.out.println("------file" + temp + "--------");
                        System.out.println("\nElement type :"
                                + node1.getNodeName());
                        Element File = (Element) node1;

                        // used for getting file level
                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("rootProfile:"
                                    + File.getAttribute("rootProfile"));
                            System.out.println("extension  : "
                                    + File.getAttribute("extension"));
                            System.out.println("seperator  : "
                                    + File.getAttribute("seperator"));
                            System.out.println("targetSeperator  : "
                                    + File.getAttribute("targetSeperator"));

                            for (int temp2 = 0; temp2 < nodeList2.getLength(); temp2++) {
                                Node node2 = nodeList2.item(temp2);
                                Element name = (Element) node2;

                                if (node2.getNodeType() == Node.ELEMENT_NODE) {
                                    System.out.println("id:"
                                            + name.getAttribute("id"));
                                    System.out.println("usn  : "
                                            + name.getAttribute("usn"));
                                    System.out.println("dob  : "
                                            + name.getAttribute("dob"));
                                    System.out.println("age  : "
                                            + name.getAttribute("age"));
                                    System.out.println("validity  : "
                                            + name.getAttribute("validity"));

                                    // to get grouped node, the problem seems to
                                    // be here
                                    // Node node3 = nodeList3.item(temp2);
                                    NodeList grouped = node2.getChildNodes();
                                    if (grouped != null
                                            && grouped.getLength() > 0) {
                                        for (int ii = 0; ii < grouped
                                                .getLength(); ii++) {
                                            Node group = grouped.item(ii);
                                            {
                                                NodeList gropedNames = group
                                                        .getChildNodes();
                                                if (gropedNames != null
                                                        && gropedNames
                                                        .getLength() > 0) {
                                                    for (int jj = 0; jj < gropedNames
                                                            .getLength(); jj++) {
                                                        if (gropedNames
                                                                .item(jj) != null
                                                                && gropedNames
                                                                .item(jj)
                                                                .getAttributes() != null) {
                                                            System.out
                                                            .println(gropedNames
                                                                    .item(jj)
                                                                    .getAttributes()
                                                                    .getNamedItem(
                                                                            "id"));
                                                            System.out
                                                            .println(gropedNames
                                                                    .item(jj)
                                                                    .getAttributes()
                                                                    .getNamedItem(
                                                                            "value1"));
                                                            System.out
                                                            .println(gropedNames
                                                                    .item(jj)
                                                                    .getAttributes()
                                                                    .getNamedItem(
                                                                            "value2"));
                                                            System.out
                                                            .println(gropedNames
                                                                    .item(jj)
                                                                    .getAttributes()
                                                                    .getNamedItem(
                                                                            "value7"));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}