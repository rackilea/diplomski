package forum16559889;

import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.NamespacePrefixMapper;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Response.class);

        Response response = new Response();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.forum-datenaustausch.ch/invoice generalInvoiceResponse_440.xsd");

        marshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, new NamespacePrefixMapper() {

            @Override
            public String getPreferredPrefix(String namespaceUri,
                    String suggestion, boolean requirePrefix) {
                if("http://www.forum-datenaustausch.ch/invoice".equals(namespaceUri)) {
                    return "invoice";
                } else if("http://www.w3.org/2000/09/xmldsig#".equals(namespaceUri)) {
                    return "ds";
                } else if("http://www.w3.org/2001/04/xmlenc#".equals(namespaceUri)) {
                    return "xenc";
                } else {
                    return null;
                }
            }

        });

        marshaller.marshal(response, System.out);
    }

}