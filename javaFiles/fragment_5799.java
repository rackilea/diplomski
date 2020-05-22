import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Span.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Span span1 = (Span) unmarshaller.unmarshal(new StringReader("<span>bla bla bla</span>"));
        System.out.println(span1.getMixed());

        Span span2 = (Span) unmarshaller.unmarshal(new StringReader("<span><div/><div/></span>"));
        System.out.println(span2.getDiv());
    }

}