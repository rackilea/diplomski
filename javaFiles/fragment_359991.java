import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import generated.VendorDocument;

public class VendorMain {

  public static void main(String[] args) throws JAXBException, IOException {

    // create JAXB context
    JAXBContext context = JAXBContext.newInstance(VendorDocument.class);

    // unmarshal document from file
    Unmarshaller um = context.createUnmarshaller();
    VendorDocument vendorDoc = (VendorDocument) um.unmarshal(new FileReader("vendor.xml"));


    //Check what got read in by writing it out.  Will not have unknown tags.
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    m.marshal(vendorDoc, new File("output.xml"));

  }
}