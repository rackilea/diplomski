import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSaxParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String xml = 
            "<content type=\"html\">\n" +
            "\n" +
            "    &lt;img alt=\"\" src=\"http://cdn2.sbnation.com/entry_photo_images/8767829/stranger-bad-robot-screencap_large.png\" /&gt;\n" +
            "\n" +
            "\n" +
            "     &lt;p&gt;Bad Robot, the production company founded by geek culture hitmaker J.J. Abrams (&lt;i&gt;Lost&lt;/i&gt;, &lt;i&gt;Fringe&lt;/i&gt;, &lt;i&gt;Star Trek: Into Darkness&lt;/i&gt;, &lt;i&gt;Alias&lt;/i&gt;,&amp;nbsp;etc.), has released a&amp;nbsp;&lt;a href=\"http://youtu.be/FWaAZCaQXdo\" target=\"_blank\"&gt;mysterious new trailer&lt;/a&gt; titled \"Stranger.\" The creepy and inscrutable video spot, posted by the official Bad Robot Twitter account this afternoon, features a starry sky; a long-haired, rope-bound man wandering along a desolate monochromatic shore line; and your garden variety, horrifying stitched-mouth person coming into focus. \"Men are erased and reborn,\" intones a narrator that sounds a little like Leonard Nimoy.&lt;/p&gt;\n" +
            "     &lt;p&gt;&lt;/p&gt;\n" +
            "\n" +
            "\n" +
            "\n" +
            "    </content>";

        MySaxHandler handler = new MySaxHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();        
        InputSource source = new InputSource(new StringReader(xml));
        parser.parse(source, handler);
    }

    private static class MySaxHandler extends DefaultHandler {
        private StringBuilder content = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            content.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            content.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println(content.toString());
        }

    }    
}