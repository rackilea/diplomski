import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum17061559/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);

        for(A a : root.getMyStuff()) {
            System.out.println(a);
        }
    }

}