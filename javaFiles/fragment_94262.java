package forum11449219;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        IPIList ipiList = new IPIList();
        ipiList.getList().add("1001");
        ipiList.getList().add("1002");

        // XML
        JAXBContext jc = JAXBContext.newInstance(IPIList.class);
        Marshaller xmkMarshaller = jc.createMarshaller();
        xmkMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        xmkMarshaller.marshal(ipiList, System.out);

        // JSON
        Map<String, Object> properties = new HashMap<String, Object>(3);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum11449219/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jsonJC = JAXBContext.newInstance(new Class[] {IPIList.class}, properties);
        Marshaller jsonMarshaller = jsonJC.createMarshaller();
        jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jsonMarshaller.marshal(ipiList, System.out);
    }

}