import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("input.xml");
        Foo foo = (Foo) unmarshaller.unmarshal(xml);

        System.out.println(foo.getBar().getClass());
    }

}