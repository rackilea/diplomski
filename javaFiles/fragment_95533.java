import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/forum18071557/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        xsr = new StreamReaderDelegate(xsr) {

            @Override
            public String getLocalName() {
                String localName = super.getLocalName();
                if(localName.startsWith("Attribute") && localName.endsWith("List")) {
                    return "AttributeList";
                } else if(localName.startsWith("Attribute") && localName.endsWith("Name")) {
                    return "AttributeName";
                } else if(localName.startsWith("Attribute")) {
                    return "ignore";
                } else {
                    return localName;
                }
            }

        };

        xsr = xif.createFilteredReader(xsr, new StreamFilter() {
            @Override
            public boolean accept(XMLStreamReader reader) {
                if(reader.isStartElement() || reader.isEndElement()) {
                    return !reader.getLocalName().equals("ignore");
                } else {
                    return true;
                }
            }

        });

        JAXBContext jc = JAXBContext.newInstance(VisitorDataList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        VisitorDataList vdl = (VisitorDataList) unmarshaller.unmarshal(xsr);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(vdl, System.out);
    }

}