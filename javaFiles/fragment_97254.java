import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class DomParserMain {
    final static String ROOT_NODE_NAME = "data";
    final static String FILE_PATH =  "/Users/file.xml";
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException, XMLStreamException, XPathExpressionException, TransformerException {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLEventReader  xmlr = null;

        xmlr = xif.createXMLEventReader((new FileInputStream(new File(FILE_PATH))));

        boolean inline = false;
        StringBuffer sb = new StringBuffer(1024 * 66);
        while(xmlr.hasNext()){
            XMLEvent event = xmlr.nextEvent();

            if (event.isStartElement() ){
                StartElement element = (StartElement) event;
                if( ROOT_NODE_NAME.equals( element.getName().toString().trim() ) ) {
                    inline = true;
                }
            }

            if(inline) {
                sb.append( xmlr.peek()  );
            }

            if (event.isEndElement() ){
                EndElement element = (EndElement)event ;
                if( ROOT_NODE_NAME.equals( element.getName().toString().trim() ))  {
                    inline = false;
                    System.out.println("=====");
                    System.out.println(sb.toString());
                    System.out.println("=====");
                    sb.setLength(0);
                }
            }
        } 
    }
}