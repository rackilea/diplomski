import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.xerces.impl.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;

public class XSDTest {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        // our XSD, which defines 1 node  <TheNode> which must have decimal text content 
        byte [] schemaData = ("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
                + "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">"
                    + "<xs:simpleType name=\"theNodeType\">"
                        + "<xs:restriction base=\"xs:decimal\"/>"
                    + "</xs:simpleType>"
                    + "<xs:element name=\"TheNode\" type=\"theNodeType\"/>"
                + "</xs:schema>").getBytes();
        // our invalid xml
        byte [] xmlData = "<TheNode>123NotADecimal</TheNode>".getBytes();

        // parse schema
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaSource = new StreamSource(new ByteArrayInputStream(schemaData));
        Schema schema = schemaFactory.newSchema(schemaSource);

        // build our document, must use document builder to enable xerces parser properties for DOM
        // Also must be a xerces implementation of the DBF, should be enabled by default in a standard java project but just to be verbose about it
        // pass in the full name of the DBF impl
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(org.apache.xerces.jaxp.DocumentBuilderFactoryImpl.class.getName(), XSDTest.class.getClassLoader());
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xmlData));


        // configure our validator and parse the document.
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler(validator));
        validator.validate(new DOMSource(doc.getDocumentElement()));
    }

    private static class MyErrorHandler implements ErrorHandler {
        private final Validator xsdValidator;

        public MyErrorHandler(Validator xsdValidator) {
            this.xsdValidator = xsdValidator;
        }
        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println("Warning on node: " + getCurrentNode());
            System.out.println(exception.getLocalizedMessage());
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.out.println("Error on node: " + getCurrentNode());
            System.out.println(exception.getLocalizedMessage());
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.out.println("Fatal on node: " + getCurrentNode());
            System.out.println(exception.getLocalizedMessage());
        }


        private Node getCurrentNode() throws SAXNotRecognizedException, SAXNotSupportedException {
            // get prop "http://apache.org/xml/properties/dom/current-element-node"
            // see https://xerces.apache.org/xerces2-j/properties.html#dom.current-element-node
            return (Node)xsdValidator.getProperty(Constants.XERCES_PROPERTY_PREFIX + Constants.CURRENT_ELEMENT_NODE_PROPERTY);
        }
    }

}