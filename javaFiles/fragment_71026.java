import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

@Provider
public class ExtendedMOXyJsonProvider extends MOXyJsonProvider {

    @Override
    protected void preWriteTo(Object object, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders, Marshaller marshaller)
            throws JAXBException {
        Boolean isPretty = Boolean.valueOf((String) httpHeaders.getFirst("pretty"));
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isPretty);
    }

}