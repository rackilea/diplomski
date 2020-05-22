import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();

        JAXBContext jc = JAXBContext.newInstance(ITEM.class);
        UnmarshallerHandler unmarshallerHandler = jc.createUnmarshaller().getUnmarshallerHandler();
        xr.setContentHandler(unmarshallerHandler);

        StringReader xml = new StringReader("<ITEM><01>Hello World</01></ITEM");
        InputSource inputSource = new InputSource(xml);
        xr.parse(inputSource);

        ITEM item = (ITEM) unmarshallerHandler.getResult();
    }

}