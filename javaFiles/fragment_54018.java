package forum11921190;

import javax.xml.stream.XMLStreamReader;
import org.xml.sax.*;

public class MyErrorHandler implements ErrorHandler {

    private XMLStreamReader reader;

    public MyErrorHandler(XMLStreamReader reader) {
        this.reader = reader;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        warning(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        warning(e);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(reader.getLocalName());
        System.out.println(reader.getNamespaceURI());
        e.printStackTrace(System.out);
    }

}