package forum11001458;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MyResult.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        File json = new File("src/forum11001458/input.json");
        Object myResult = unmarshaller.unmarshal(json);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(myResult, System.out);
    }

}