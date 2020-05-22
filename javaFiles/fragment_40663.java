import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
    JAXBContext jc = JAXBContext.newInstance(Items.class);

    Items items = new Items();
    items.getItems().add("apple");
    items.getItems().add("banana");
    items.getItems().add("orange");

    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setAdapter(new StringAdapter());
    marshaller.marshal(items, System.out);
    }

}