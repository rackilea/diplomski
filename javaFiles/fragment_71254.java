import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ResponseResolver implements ContextResolver<JAXBContext> {
    private JAXBContext ctx;

    public ResponseResolver() {
        try {
            this.ctx = JAXBContext.newInstance(

                        Response.class, 
                        Department.class

                    );
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    public JAXBContext getContext(Class<?> type) {
        return (type.equals(Response.class) ? ctx : null);
    }
}