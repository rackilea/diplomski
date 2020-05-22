import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class orderXML {

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("src/Content.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getChildNodes();

            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("    READ ORDER              ");
            System.out.println("++++++++++++++++++++++++++++");     

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);          

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    Element eElement = (Element) nNode;
                    System.out.println("Id : " + eElement.getAttribute("id"));
                    System.out.println("Content : " + eElement.getTextContent());
                }
            }           

            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("    ID ORDER                ");
            System.out.println("++++++++++++++++++++++++++++");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node node=returnNodeByValue(nList, "id", String.valueOf(temp));

                if(node!=null && node.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println("\nCurrent Element :" + node.getNodeName());
                    Element eElement = (Element) node;
                    System.out.println("Id : " + eElement.getAttribute("id"));
                    System.out.println("Content : " + eElement.getTextContent());   
                }               
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
      }

    /**
     * Returns a Node by attribute name and attribute value.
     * @param nodeList  NodeList where we find the node
     * @param attributeName Attribute name to search
     * @param attributeValue Attribute name to search
     * @return If exists a node with attributeName and attributeValue returns this Node,
     *      if not exists, returns null
     */
    private static Node returnNodeByValue(NodeList nodeList, String attributeName, String attributeValue) {
        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);           

            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                String returnAttribute = eElement.getAttribute(attributeName);
                if(returnAttribute.equals(attributeValue)){
                    return nNode;
                }
            }                           

        }
        return null;
    }
}