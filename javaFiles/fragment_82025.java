import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Test {

    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
    Source xslt = new StreamSource(new File("transform.xslt"));
    Transformer transformer = factory.newTransformer(xslt);

    Source text = new StreamSource(new File("data.xml"));
    transformer.transform(text, new StreamResult(new File("output.xml")));
    System.out.println("Done");
    }

}