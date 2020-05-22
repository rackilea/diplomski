import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class Test {

    @XmlAccessorType(XmlAccessType.PROPERTY)
    public static class Bar {
        private String name;

        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }
    }

    @XmlAccessorType(XmlAccessType.PROPERTY)
    public static class Container implements Serializable {
        private Bar bar;

        public Bar getBar() {
            return bar;
        }

        @XmlElement
        public void setBar(Bar bar) {
            this.bar = bar;
        }
    }

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Container.class);
        String xml = "<foo><bar><name>Barry</name></bar></foo>";
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        JAXBElement<Container> barWrapperElement = unmarshaller.unmarshal(new StreamSource(is), Container.class);
        Container container = barWrapperElement.getValue();

        System.out.println(container.getBar().getName());
    }
}