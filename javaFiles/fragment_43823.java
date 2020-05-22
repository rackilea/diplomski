import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(B1.class, B2.class);

        B1 b1 = new B1();
        JAXBElement<A> jaxbElement = new JAXBElement<A>(new QName("root"), A.class, b1);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jaxbElement, System.out);
    }

}