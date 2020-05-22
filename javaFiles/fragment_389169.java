package forum9799081;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MyBean.class);

        File xml = new File("src/forum9799081/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        MyBean myBean = (MyBean) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(myBean, System.out);
    }

}