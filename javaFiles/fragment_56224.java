import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Stereotypes.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Stereotypes stereotypes = (Stereotypes) unmarshaller.unmarshal(new File("input.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(stereotypes, System.out);

    }
}