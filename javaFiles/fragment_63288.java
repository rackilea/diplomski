import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(PersonCollection.class, Person.class);

        PersonCollection pc = new PersonCollection();
        pc.getCollection().add(new Person());
        pc.getCollection().add(new Person());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(pc, System.out);
    }

}