package forum9629948;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(A.class);

        File xml = new File("src/forum9629948/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        A a = (A) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(a, System.out);
    }

}