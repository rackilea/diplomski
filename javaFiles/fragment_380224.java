import animals.Animal;
import javax.xml.bind.*;

public class App {

    public static void main(String[] args) throws JAXBException {
        Animal tiger = new Animal();
        tiger.setType("carnivore");
        tiger.setValue("Tiger");

        JAXBContext jaxbContext = JAXBContext.newInstance(Animal.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(tiger, System.out);
    }
}