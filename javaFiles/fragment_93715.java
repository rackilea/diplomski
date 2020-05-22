import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.Version;

public class Demo {

    public static void main(String[] args) throws Exception {
        System.out.println(Version.getVersionString());

        JAXBContext jc = JAXBContext.newInstance(B.class);
        System.out.println(jc);

        B b = new B();
        b.setC(new C());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(b,System.out);
    }

}