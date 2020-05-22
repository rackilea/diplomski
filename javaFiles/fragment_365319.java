package forum9812778;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Cars.class);

        File xml = new File("src/forum9812778/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Cars cars = (Cars) unmarshaller.unmarshal(xml);

        for(Car car : cars.getCar()) {
            System.out.println(car.getClass());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cars, System.out);
    }

}