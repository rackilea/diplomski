package forum11693552;

import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

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