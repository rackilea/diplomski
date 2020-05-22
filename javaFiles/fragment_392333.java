import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class GetNamedItemNSTester
{
    public static void main(String[] args)
    {
        new GetNamedItemNSTester();     
    }

    String xml = "<xml xmlns:log=\"http://sample.com\">\n" +
            "\n" +
            "<test log:writer=\"someWriter\" />\n" +
            "\n" +
            "</xml>";


    public GetNamedItemNSTester()
    {
        StringReader xmlReader = new StringReader(xml);
        try
        {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(xmlReader));

            Element currentNode =
                (Element)doc.getElementsByTagName("test").item(0);
            String attributeValue = currentNode.getAttributes()
                .getNamedItemNS("http://sample.com", "writer").getNodeValue();
            System.out.println("Attribute value is " + attributeValue);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            xmlReader.close();
        }
    }
}