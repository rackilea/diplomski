package forum11537931;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        // XML
        JAXBContext jc = JAXBContext.newInstance(Work.class, Registry.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11537931/input.xml");
        Work work = (Work) unmarshaller.unmarshal(xml);

        // JSON
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum11537931/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        JAXBContext jsonJC = JAXBContext.newInstance(new Class[] {Work.class, Registry.class}, properties);
        Marshaller jsonMarshaller = jsonJC.createMarshaller();
        jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jsonMarshaller.marshal(work, System.out);
    }

}