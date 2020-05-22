import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(P1.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13987708/input.xml");
        P1 p1 = (P1) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(p1, System.out);
    }

}