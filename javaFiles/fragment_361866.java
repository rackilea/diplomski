import java.util.*;
import javax.xml.bind.JAXBContext;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.oxm.XMLDescriptor;
import org.eclipse.persistence.sessions.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.SESSION_EVENT_LISTENER, new SessionEventAdapter() {

            @Override
            public void preLogin(SessionEvent event) {
                for(Map.Entry<Class, ClassDescriptor> entry : event.getSession().getProject().getDescriptors().entrySet()) {
                    XMLDescriptor a;
                    ((XMLDescriptor) entry.getValue()).setLazilyInitialized(true);
                }
            }

        });
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Root.class}, properties);
    }

}