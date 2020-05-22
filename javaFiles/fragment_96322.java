import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {

        JAXBContext jc = JAXBContext.newInstance(MyBean.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource source = new StreamSource("input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(source);
        xsr = new StreamReaderDelegate(xsr) {

            @Override
            public String getText() {
                String text = super.getText();
                if(text.contains("${")) {
                    text = System.getProperty(text);
                }
                return text;
            }

        };

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.unmarshal(xsr);
    }

}