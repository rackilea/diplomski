import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 *  Uses a decorator ContentHandler to insert a "tee" into a SAX parse/serialize
 *  stream.
 */
public class SaxTeeExample
{
    public static void main(String[] argv)
    throws Exception
    {
        StringReader src = new StringReader("<root><child>text</child></root>");
        StringWriter dst = new StringWriter();

        Transformer xform = TransformerFactory.newInstance().newTransformer();
        XMLReader reader = new MyReader(SAXParserFactory.newInstance().newSAXParser());
        xform.transform(new SAXSource(reader, new InputSource(src)),
                        new StreamResult(dst));

        System.out.println(dst.toString());
    }


    private static class MyReader
    extends XMLFilterImpl
    {
        private SAXParser _parser;

        public MyReader(SAXParser parser)
        {
            _parser = parser;
        }

        @Override
        public void parse(InputSource input) 
        throws SAXException, IOException
        {
            _parser.parse(input, new XMLFilterBridge(this));
        }

        // this is an example of a "tee" function
        @Override
        public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException
        {
            System.out.println("startElement: " + name);
            super.startElement(uri, localName, name, atts);
        }
    }


    private static class XMLFilterBridge
    extends DefaultHandler
    {
        private XMLFilterImpl _filter;

        public XMLFilterBridge(XMLFilterImpl myFilter)
        {
            _filter = myFilter;
        }

        @Override
        public void characters(char[] ch, int start, int length)
        throws SAXException
        {
            _filter.characters(ch, start, length);
        }

        // override all other methods of DefaultHandler
        // ...
    }
}