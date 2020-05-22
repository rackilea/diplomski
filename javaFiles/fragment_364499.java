package forum13709611;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Book.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        String code = "<book><title>Harry Potter</title></book>";
        StreamSource source = new StreamSource(new StringReader(code));
        JAXBElement<Book> jaxbElement = unmarshaller.unmarshal(source, Book.class);
    }

}