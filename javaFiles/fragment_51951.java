import java.io.*;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class RemoveBlock {

     public static void removeAll(Node node, short nodeType, String name) {
            if (node.getNodeType() == nodeType &&
                    (name == null || node.getNodeName().equals(name))) {
                node.getParentNode().removeChild(node);
            } else {

                NodeList list = node.getChildNodes();
                for (int i=0; i<list.getLength(); i++) {
                    removeAll(list.item(i), nodeType, name);
                }
            }
        }

  static public void main(String[] arg) {
    try{
      String xmlFile = "Management.xml";
      File file = new File(xmlFile);
      String remElement = "Physical_Order_List_Array";
      if (file.exists()){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer tFormer = tFactory.newTransformer();
        // Obtain a node
        Element element = (Element)doc.getElementsByTagName(remElement).item(0);


        element.getParentNode().removeChild(element);


        removeAll(doc, Node.ELEMENT_NODE, remElement);

        doc.normalize();
        Source source = new DOMSource(doc);
        Result dest = new StreamResult(new FileOutputStream("Management.xml"));
        tFormer.transform(source, dest);
      }
      else{
        System.out.println("File not found!");
      }
    }
    catch (Exception e){
      System.err.println(e);
      System.exit(0);
    }
  }
}