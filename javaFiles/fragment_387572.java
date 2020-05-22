import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

...
SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = schemaFactory.newSchema(new File("<path to the xsd>"));

SAXParserFactory spf = SAXParserFactory.newInstance();
spf.setValidating(false);
spf.setSchema(schema);

XMLReader xmlReader = spf.newSAXParser().getXMLReader();
xmlReader.setContentHandler(...);
xmlReader.parse(new InputSource(...)); // will validate against the schema