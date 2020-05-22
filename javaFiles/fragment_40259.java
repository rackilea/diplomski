package forum9862100;

import java.io.File;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Parent.class);

        StreamSource json = new StreamSource(new File("src/forum9862100/input.json"));
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        unmarshaller.setProperty("eclipselink.json.include-root", false);
        unmarshaller.setAdapter(new ChildAdapter());
        Parent parent = (Parent) unmarshaller.unmarshal(json, Parent.class).getValue();

        System.out.println(parent.field1 == parent.field2);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.setProperty("eclipselink.json.include-root", false);
        marshaller.setAdapter(new ChildAdapter());
        marshaller.marshal(parent, System.out);
    }

}