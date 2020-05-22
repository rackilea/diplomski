package forum10548370;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Message.class);

        File xml = new File("src/forum10548370/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Message message = (Message) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(message, System.out);
    }

}