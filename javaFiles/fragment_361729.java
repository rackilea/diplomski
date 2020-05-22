package forum16559889;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Response.class);

        Response response = new Response();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.forum-datenaustausch.ch/invoice generalInvoiceResponse_440.xsd");
        marshaller.marshal(response, System.out);
    }

}