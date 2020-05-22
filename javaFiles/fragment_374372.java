import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();
        File xsdFile = new File("./resource/test.xsd").getAbsoluteFile();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(xsdFile);

        JAXBContext jaxbContext = JAXBContext.newInstance(DataFile.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);

        Object root = unmarshaller.unmarshal(xmlFile);
        System.out.println(root);
    }
}