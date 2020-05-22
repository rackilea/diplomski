import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Simple.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource source = new StreamSource("src/forum22911170/input.xml");
        Simple simple = unmarshaller.unmarshal(source, Simple.class).getValue();

        System.out.println(simple.getContent());
    }

}