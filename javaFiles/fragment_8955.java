import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test{

    public static void main(String[] args){
         try {
             File myXmlFile = new File("src/test.xml");
             String xpath_PrdNotes = "/Envelope/Body/GetCardResponse/GetCardResult/ReturnResult/GetCardResult/PrdInfoTable/PrdNote/text()";
             String xpath_TxetContent = "/Envelope/Body/GetCardResponse/GetCardResult/ReturnResult/GetCardResult/OrdInfoTable/TxetContent/text()";

             ArrayList<String> prdNotesValues = extractNodesValues(myXmlFile, xpath_PrdNotes );
             ArrayList<String> txetContentValues = extractNodesValues(myXmlFile, xpath_TxetContent );

             System.out.println("PrdNotesValues:");
             for(String val : prdNotesValues){                   
                 System.out.println(val);
             }
             System.out.println("");
             System.out.println("TxetContentValues:");               
             for(String val : txetContentValues){                    
                 System.out.println(val);
             }               
         }

         catch(XPathExpressionException e){ System.out.println(e.getMessage()); }
         catch(IOException e){ System.out.println(e.getMessage()); }
         catch(SAXException e){ System.out.println(e.getMessage()); }
         catch(ParserConfigurationException e){ System.out.println(e.getMessage()); }
   }

   public static ArrayList<String> extractNodesValues(File f, String xpath_expression) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException  {      
        Document xmlDocument;       
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();         
        DocumentBuilder builder;
        XPath xPath;
        NodeList nodeList;        
        Node n; 
        ArrayList<String> result;

        builder = builderFactory.newDocumentBuilder();
        xmlDocument = builder.parse(f);              
        xPath =  XPathFactory.newInstance().newXPath();                                  
        result = new ArrayList<String>();

        // here all values from PrdNote elements are stored
        nodeList = (NodeList)xPath.compile(xpath_expression).evaluate(xmlDocument, XPathConstants.NODESET);        

        if(nodeList != null && nodeList.getLength() > 0) {
            //iterate over all obtained nodes matching the xpath expression
            for(int i=0; i<nodeList.getLength(); i++){                  
                result.add(nodeList.item(i).getNodeValue());
            }               
        }           
        return result;
    } 
}