import javax.xml.bind.*;
import javax.xml.soap.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        MessageFactory mf = MessageFactory.newInstance();
        SOAPMessage message = mf.createMessage();
        SOAPBody body = message.getSOAPBody();

        Foo foo = new Foo();
        foo.setBar("Hello World");

        JAXBContext jc = JAXBContext.newInstance(Foo.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(foo, body);

        message.saveChanges();
        message.writeTo(System.out);
    }

}