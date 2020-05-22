package forum11693552;

import java.util.*;
import javax.xml.bind.*;
import javax.xml.namespace.QName;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String,Object>(1);
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum11693552/oxm.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Customer.class}, properties);

        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Doe");

        PhoneNumber workPhone = new PhoneNumber();
        workPhone.setType("work");
        workPhone.setNumber("555-1111");
        customer.getPhoneNumbers().add(workPhone);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> rootElement = new JAXBElement<Customer>(new QName("customer"), Customer.class, customer);
        marshaller.marshal(rootElement, System.out);
    }

}