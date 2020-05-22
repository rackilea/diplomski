import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Test 
{
    public static void main(String[] args) throws Exception
    {
        Document doc = getDoc();
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPath.compile("//codes/code[@code ='ABC']");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;
        System.out.println("Have I found anything? " + (nodes.getLength() > 0 ? "Yes": "No"));

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("nodes: "+ nodes.item(i).getNodeValue()); 
        }

    }

    private static Document getDoc() 
    {
        String xml = "<metadata>"+
                 "<codes class = 'class1'>"+
                      "<code code='ABC'>"+
                            "<detail x='blah blah'/>"+
                        "</code>"+
                  "</codes>"+
                  "<codes class = 'class2'>"+
                      "<code code = '123'>"+
                            "<detail x='blah blah'/>"+
                        "</code>"+
                  "</codes>"+
                 "</metadata>";


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(new ByteArrayInputStream(xml.getBytes()));
            return dom;

        }catch(Exception pce) {
            pce.printStackTrace();
        }
        return null;
    }
}