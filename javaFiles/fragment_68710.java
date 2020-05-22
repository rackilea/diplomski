import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(X.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);

        xsw.writeStartDocument();
        xsw.writeStartElement("x");
        xsw.writeStartElement("y");
        xsw.writeStartElement("k");

        X x1 = new X();
        x1.setId(1);
        JAXBElement<X> jaxbElement1 = new JAXBElement<X>(new QName("x1"), X.class, x1);
        marshaller.marshal(jaxbElement1, xsw);

        X x2 = new X();
        x2.setId(1);
        JAXBElement<X> jaxbElement2 = new JAXBElement<X>(new QName("x2"), X.class, x2);
        marshaller.marshal(jaxbElement2, xsw);

        X x3 = new X();
        x3.setId(3);
        JAXBElement<X> jaxbElement3 = new JAXBElement<X>(new QName("x3"), X.class, x3);
        marshaller.marshal(jaxbElement3, xsw);

        xsw.writeEndElement();
        xsw.writeEndElement();
        xsw.writeEndElement();
        xsw.writeEndDocument();
    }
}