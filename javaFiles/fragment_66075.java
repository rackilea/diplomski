import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class XmlParser {

static void parse(String xml, Handler handler) throws SAXException, ParserConfigurationException, IOException
{
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    XMLReader reader = saxParserFactory.newSAXParser().getXMLReader();
    reader.setContentHandler(handler);
    reader.parse(new InputSource(new CharArrayReader(xml.toCharArray())));
}

static class Handler extends DefaultHandler {

    CharArrayWriter contents = new CharArrayWriter();

    static enum STATE { Family, Remaining }
    STATE state;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equals("ChildList"))
            state = STATE.Family;
        else if (qName.equals("RemainingChildList"))
            state = STATE.Remaining;
        else if (qName.equals("ChildID"))
            contents.reset();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("ChildID"))
            System.out.println(contents.toString() + " [" + state + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        contents.write(ch, start, length);
    }
}

public static void main(String[] args) throws Exception
{
    String xml = "<FosterHome>\n" +
        "<Orphanage>Happy Days Daycare</Orphanage>\n" +
        "<Location>Apple Street</Location>\n" +
        "<Families>\n" +
        "    <Family>\n" +
        "        <ParentID>Adams</ParentID>\n" +
        "        <ChildList>\n" +
        "            <ChildID>Child1</ChildID>\n" +
        "            <ChildID>Child2</ChildID>\n" +
        "        </ChildList>\n" +
        "    </Family>\n" +
        "    <Family>\n" +
        "        <ParentID>Adams</ParentID>\n" +
        "        <ChildList>\n" +
        "            <ChildID>Child3</ChildID>\n" +
        "            <ChildID>Child4</ChildID>\n" +
        "        </ChildList>\n" +
        "    </Family>\n" +
        "</Families>\n" +
        "<RemainingChildList>\n" +
        "<ChildID>Child5</ChildID>\n" +
        "<ChildID>Child6</ChildID>\n" +
        "</RemainingChildList>\n" +
        "</FosterHome>";

    parse(xml, new Handler());
}
}