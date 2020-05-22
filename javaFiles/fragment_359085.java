import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ServiceRq.class);
        System.out.println(jc);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        ServiceRq serviceRq = (ServiceRq) unmarshaller.unmarshal(new File("input.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(serviceRq, System.out);

    }

}