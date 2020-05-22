package forum13872065;

import javax.xml.bind.*;
import javax.xml.datatype.DatatypeFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Root root = new Root();
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        root.month = dtf.newXMLGregorianCalendar("--11");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}