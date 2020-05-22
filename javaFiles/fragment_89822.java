import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Frm.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource source = new StreamSource("src/forum18096385/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(source);
        xsr = new StreamReaderDelegate(xsr) {

            @Override
            public String getLocalName() {
                String localName = super.getLocalName();
                int underScoreIndex = localName.indexOf('_');
                if(underScoreIndex >= 0) {
                    return localName.substring(0, underScoreIndex);
                }
                return localName;
            }

        };

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Frm frm = (Frm) unmarshaller.unmarshal(xsr);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(frm, System.out);
    }

}