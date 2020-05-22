import java.io.File;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MovieImpl.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum21764131/input.xml");
        Movie movie = (Movie) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(MarshallerProperties.OBJECT_GRAPH, "partial");
        marshaller.marshal(movie.getActors().toArray()[0], System.out);
    }

}