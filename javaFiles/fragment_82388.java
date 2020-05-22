import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Object o;

        o = unmarshaller.unmarshal(new File("input1.xml"));
        marshaller.marshal(o, System.out);

        o = unmarshaller.unmarshal(new File("input2.xml"));
        marshaller.marshal(o, System.out);

        o = unmarshaller.unmarshal(new File("input3.xml"));
        marshaller.marshal(o, System.out);
    }

}