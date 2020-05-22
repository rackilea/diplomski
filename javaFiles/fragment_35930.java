import java.io.FileInputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class Example {

    private static class ToLowerCaseNamesStreamReaderDelegate extends StreamReaderDelegate {

        public ToLowerCaseNamesStreamReaderDelegate(XMLStreamReader xsr) {
            super(xsr);
        }

        @Override
        public String getAttributeLocalName(int index) {
            return super.getAttributeLocalName(index).toLowerCase();
        }

        @Override
        public String getLocalName() {
            return super.getLocalName().toLowerCase();
        }

    }


    @XmlRootElement(name="doc")
    static class Doc {
        @XmlElement(name="element")
        List<Element> elements;
    }

    static class Element {
        @XmlAttribute(name = "abc")
        String abc;
    }

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("LowerCaseElementNamesFilterTest.xml"));

        Unmarshaller u = JAXBContext.newInstance(Doc.class).createUnmarshaller();

        //Do unmarshalling
        Doc doc = (Doc) u.unmarshal(new ToLowerCaseNamesStreamReaderDelegate(xsr));

        System.out.println(doc.elements.get(0).abc);
        System.out.println(doc.elements.get(1).abc);
        System.out.println(doc.elements.get(2).abc);

    }
}