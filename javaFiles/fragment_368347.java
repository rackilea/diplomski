import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBExample {
    public static void main(String[] args) {
        Token token = new Token();
        token.setHighLevel(new HighLevelToken("1", "2"));
        token.setLowLevel(new HashMap<String, String>() {{ put("LK1", "LV1"); put("LK2", "LV2"); put("LK2", "LV2"); }});
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Token.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(token, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}