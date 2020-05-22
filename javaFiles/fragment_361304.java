import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

SAXParser parser = /* created from SAXParserFactory */;
XMLReader reader = parser.getXMLReader();
try {
    reader.setFeature("http://apache.org/xml/features/xinclude", 
                      true);
} 
catch (SAXException e) {
    System.err.println("could not set parser feature");
}