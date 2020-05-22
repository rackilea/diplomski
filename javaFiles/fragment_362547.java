package blog.bindingfile.jaxrs;

import java.io.*;
import java.util.*;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

import blog.bindingfile.Customer;

@Provider
@Produces({"application/xml", "application/json"})
public class CustomerContextResolver implements ContextResolver<JAXBContext> {

    private JAXBContext jc;

    public CustomerContextResolver() {
        Map<String, Object> props = new HashMap<String, Object>(1);
        props.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "blog/bindingfile/binding.xml");
        jc = JAXBContext.newInstance(new Class[] {Customer.class} , props);
    }

    public JAXBContext getContext(Class<?> clazz) {
        if(Customer.class == clazz) {
            return jc;
        }
        return null;
    }

}