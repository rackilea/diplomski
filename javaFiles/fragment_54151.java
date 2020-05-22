package forum10566766;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Article.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum10566766/input.xml");
        Article article = (Article) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(article, System.out);
    }

}