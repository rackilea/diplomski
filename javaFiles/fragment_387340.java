package forum7014746;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Food.class);

        Food foodSchema = new Food();
        foodSchema.setFood("steak");
        foodSchema.setBeverage("water");

        JAXBElement<Food> element = new JAXBElement<Food> (new QName("http://www.something.com/something","FoodSchema"), Food.class, foodSchema);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(element, System.out);
    }

}