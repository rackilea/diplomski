package forum7652387;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Person.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        unmarshaller.setProperty("eclipselink.json.include-root", false);
        String jsonString = "{\"name\":\"John\", \"homeAddress_street\":\"123 Street\", \"homeAddress_zip\":\"xxxxx\"}";
        StreamSource jsonSource = new StreamSource(new StringReader(jsonString));
        Person person = unmarshaller.unmarshal(jsonSource, Person.class).getValue();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.setProperty("eclipselink.json.include-root", false);
        marshaller.marshal(person, System.out);
    }

}