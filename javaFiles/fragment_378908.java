import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AlphabetReq.class, AlphabetResp.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum18741690/input.xml");
        AlphabetReq ar = (AlphabetReq) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(ar, System.out);
    }

}