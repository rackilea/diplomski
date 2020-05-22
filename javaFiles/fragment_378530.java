import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MeasureParser {

    @XmlRootElement(name = "measure")
    public static class Measure {
        @XmlAttribute(name = "id")
        private String id;

        @XmlAttribute(name = "measuretype")
        private String measureType;

        @XmlAttribute(name = "userdefined")
        private boolean userDefined;
    }

    @XmlRootElement(name = "measures")
    public static class MeasureListWrapper {

        private List<Measure> measureProperties = new ArrayList<>();

        @XmlElement(name = "measure")
        public List<Measure> getMeasures() {
            return measureProperties;
        }
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MeasureListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        // Reading XML from the file and unmarshalling.
        MeasureListWrapper wrapper = (MeasureListWrapper) um.unmarshal(new File("test.xml"));

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "file:///C:/Users/mydesk/Desktop/FirstXSD.xml");
        marshaller.marshal(wrapper, System.out);
    }
}