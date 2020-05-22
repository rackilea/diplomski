import java.io.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.*;

@XmlRootElement
public class Login {

    private JAXBContext jaxbContext;
    private XMLOutputFactory xmlOutputFactory;

    public Login() {
        try {
            jaxbContext = JAXBContext.newInstance(Login.class);
            xmlOutputFactory = XMLOutputFactory.newFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Login demo = new Login();
        System.out.println(demo.getMessage());
    }

    public final String getMessage() {
        try {
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty("jaxb.encoding", "ISO-8859-1");
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(baos, (String) jaxbMarshaller.getProperty(Marshaller.JAXB_ENCODING));
            xmlStreamWriter.writeStartDocument((String) jaxbMarshaller.getProperty(Marshaller.JAXB_ENCODING), "1.0");
            jaxbMarshaller.marshal(this, xmlStreamWriter);
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
            return new String(baos.toByteArray());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}