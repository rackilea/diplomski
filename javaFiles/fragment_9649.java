import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ITEM.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<ITEM><01>Hello World</01></ITEM");
        XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(xml);
        ITEM item = (ITEM) unmarshaller.unmarshal(xsr);
    }

}