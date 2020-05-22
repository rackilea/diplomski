import java.util.*;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

@Provider
@Produces({"application/xml", "application/json"})
public class SampleContextResolver implements ContextResolver<JAXBContext> {

    private JAXBContext jc;

    public SampleContextResolver() {
        try {
            jc = JAXBContext.newInstance("org.w3._2004._08.xop.include");
        } catch(JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public JAXBContext getContext(Class<?> clazz) {
        if(clazz.getPackage().getName().equals("org.w3._2004._08.xop.include")) {
            return jc;
        }
        return null;
    }

}