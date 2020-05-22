package forum13648734;

import java.util.*;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {JsonBean.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource json = new StreamSource("src/forum13648734/input.json");
        JsonBean jsonBean = unmarshaller.unmarshal(json, JsonBean.class).getValue();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(jsonBean, System.out);
    }

}