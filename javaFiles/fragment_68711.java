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
        xsw.writeCharacters("\n");
        xsw.writeStartElement("x");
        xsw.writeCharacters("\n\t");
        xsw.writeStartElement("y");
        xsw.writeCharacters("\n\t\t");
        xsw.writeStartElement("k");

        X x1 = new X();
        x1.setId(1);
        x1.setF1("x1f1");
        JAXBElement<X> jaxbElement1 = new JAXBElement<X>(new QName("x1"), X.class, x1);
        xsw.writeCharacters("\n\t\t\t");
        marshaller.marshal(jaxbElement1, xsw);

        X x2 = new X();
        x2.setId(1);
        x2.setF1("x2f1");
        JAXBElement<X> jaxbElement2 = new JAXBElement<X>(new QName("x2"), X.class, x2);
        xsw.writeCharacters("\n\t\t\t");
        marshaller.marshal(jaxbElement2, xsw);

        X x3 = new X();
        x3.setId(3);
        x3.setF1("x3f1");
        JAXBElement<X> jaxbElement3 = new JAXBElement<X>(new QName("x3"), X.class, x3);
        xsw.writeCharacters("\n\t\t\t");
        marshaller.marshal(jaxbElement3, xsw);

        xsw.writeCharacters("\n\t\t");
        xsw.writeEndElement();
        xsw.writeCharacters("\n\t");
        xsw.writeEndElement();
        xsw.writeCharacters("\n");
        xsw.writeEndElement();
        xsw.writeEndDocument();
    }

}