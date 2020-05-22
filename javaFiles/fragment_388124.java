import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

task validateXml {
    File xml = new File('./test.xml');
    File xsd = new File('./test.xsd');

    def factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    def schema = factory.newSchema(xsd);
    def validator = schema.newValidator();
    validator.validate(new StreamSource(xml));
}