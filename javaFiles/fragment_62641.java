import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXmlUpToSomeElementSaxParser extends DefaultHandler {

    private final String lastElementToRead;

    public ReadXmlUpToSomeElementSaxParser(String lastElementToRead) {
        this.lastElementToRead = lastElementToRead;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // just for showing what is parsed
        System.out.println("startElement: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastElementToRead.equals(qName)) {
            throw new MySaxTerminatorException();
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        try {
            saxParser.parse("src/test.xml", new ReadXmlUpToSomeElementSaxParser("second"));
        } catch (MySaxTerminatorException exp) {
            // nothing to do, expected
        }
    }

    public class MySaxTerminatorException extends SAXException {
    }

}