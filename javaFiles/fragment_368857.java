package testjaxb;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

public class MarshalWithFilter {

    public static void main(String[] args) throws Exception {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<root xmlns=\"http://www.w3.org/namespace/\">\n"
                + "    <foo id=\"123\">\n"
                + "        <bar>value</bar>\n"
                + "    </foo>\n"
                + "</root>";

        String xmlStringWithoutNs = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<root>\n"
                + "    <foo id=\"123\">\n"
                + "        <bar>value</bar>\n"
                + "    </foo>\n"
                + "</root>";

        Root r = (Root) unmarshal(xmlString);
        System.out.println("root.." + r.getFoo().getId());
        System.out.println("root.." + r.getFoo().getBar());
        r = (Root) unmarshal(xmlStringWithoutNs);
        System.out.println("root.." + r.getFoo().getId());
        System.out.println("root.." + r.getFoo().getBar());
    }

    private static Root unmarshal(String sampleXML) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        IngoreNamespaceFilter nsFilter = new IngoreNamespaceFilter();
        nsFilter.setParent(reader);
        StringReader stringReader = new StringReader(sampleXML);
        InputSource is = new InputSource(stringReader);
        SAXSource source = new SAXSource(nsFilter, is);
        System.out.println("" + sampleXML);
        return (Root) unmarshaller.unmarshal(source);
    }
}

class IngoreNamespaceFilter extends XMLFilterImpl {

    public IngoreNamespaceFilter() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String arg0, String arg1, String arg2,
            Attributes arg3) throws SAXException {

        super.startElement("", arg1, arg2, arg3); //Null uri
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2)
            throws SAXException {

        super.endElement("", arg1, arg2); //null url
    }

    @Override
    public void startPrefixMapping(String prefix, String url)
            throws SAXException {
        //ignore namessopace

    }

}