import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

public class JSONMoxyTest {

    public static void main(String[] args) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(TestBean.class).createUnmarshaller();
        unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
        String jsonStr = "{\"name\":\"A\\\\B\"}"; //{"name":"A\\B"}
        TestBean bean = unmarshaller.unmarshal(new StreamSource(new StringReader(jsonStr )), TestBean.class).getValue();
        System.out.println(bean.getName());
    }

}