package forum9419732;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer();
        customer.setId(123);
        customer.setFirstName("Jane");
        customer.setLastName("Doe");

        // VENDOR 1
        JAXBContext jcV1 = JAXBContext.newInstance(Customer.class);
        marshal(jcV1, customer);

        // VENDOR 2
        Map<String, Object> propertiesV2 = new HashMap<String, Object>(1);
        propertiesV2.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum9419732/oxm-v2.xml");
        JAXBContext jcV2 = JAXBContext.newInstance(new Class[] {Customer.class}, propertiesV2);
        marshal(jcV2, customer);

        // VENDOR 3
        Map<String, Object> propertiesV3 = new HashMap<String, Object>(1);
        propertiesV3.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum9419732/oxm-v3.xml");
        JAXBContext jcV3 = JAXBContext.newInstance(new Class[] {Customer.class}, propertiesV3);
        marshal(jcV3, customer);

        // VENDOR 4
        Map<String, Object> propertiesV4 = new HashMap<String, Object>(1);
        List<String> oxmV4 = new ArrayList<String>(2);
        oxmV4.add("forum9419732/oxm-v2.xml");
        oxmV4.add("forum9419732/oxm-v3.xml");
        propertiesV4.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, oxmV4);
        JAXBContext jcV4 = JAXBContext.newInstance(new Class[] {Customer.class}, propertiesV4);
        marshal(jcV4, customer);
    }

    private static void marshal(JAXBContext jc, Customer customer) throws JAXBException {
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
        System.out.println();
    }

}