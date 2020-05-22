package forum11921190;

import javax.xml.XMLConstants;
import javax.xml.stream.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class Demo {

    private static final StreamSource XSD = new StreamSource("src/forum11921190/schema.xsd");
    private static final StreamSource XML = new StreamSource("src/forum11921190/input.xml");

    public static void main(String[] args) throws Exception {
        SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(XSD);

        XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(XML);

        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler(reader));
        validator.validate(new StAXSource(reader));

    }

}