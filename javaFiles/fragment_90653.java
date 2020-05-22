package forum14045961;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Property.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum14045961/input.xml");
        Property property = (Property) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(property, System.out);
    }

}