import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.attachment.AttachmentUnmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Demo.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setAttachmentUnmarshaller(new MyAttachmentUnmarshaller());
    }

    private static class MyAttachmentUnmarshaller extends AttachmentUnmarshaller {

        @Override
        public DataHandler getAttachmentAsDataHandler(String cid) {
            // TODO - Lookup MIME content by content-id, cid, and return as a DataHandler.
            ...
        }

        @Override
        public byte[] getAttachmentAsByteArray(String cid) {
            // TODO - Retrieve the attachment identified by content-id, cid, as a byte[]
            ...
        }

    }

}