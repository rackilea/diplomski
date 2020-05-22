import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Home.class, Person.class, Animal.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource xml = new StreamSource("src/forum20329510/input.xml");
        Home home = unmarshaller.unmarshal(xml, Home.class).getValue();

        for(Object object : home.any) {
            System.out.println(object.getClass());
        }
    }

}