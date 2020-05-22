package forum6907225;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.Version;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(TestClass.class);
        System.out.println(Version.getVersionString());

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum6907225/input.xml");
        TestClass testClass = (TestClass) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testClass, System.out);
    }

}