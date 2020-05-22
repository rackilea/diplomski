import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
...

public class GeneratorClass extends AbstractGenerator {

    private String foo;

    @Override
    public void setup(SourceResolver resolver, Map objectModel, String src, Parameters params) throws ProcessingException, SAXException, IOException {
        super.setup(resolver, objectModel, src, params);
        // you can read input parameters in here:
        foo = params.getParameter("someParameter");
    }

    public void generate() throws IOException, SAXException, ProcessingException {
        ArrayList<ResultBean> beans = xQuery(foo);

        // Let's build the XML document. I'll do it by manually appending text strings,
        // but there is no need, we could just use Xstream or any similar library
        StringBuilder xml = new StringBuilder();
        xml.append("<results>");

        // Iterate through the array list...
        for (ResultBean b : beans) {
            xml.append("<result>");
            xml.append("<id>").append(b.getId()).append("</id>");
            xml.append("<title>").append(b.getTitle()).append("</title>");
            xml.append("</result>");
        }

        // ... and we end the XML string
        xml.append("</results>");

        // Return the XML to Cocoon's pipeline
        XMLReader xmlreader = XMLReaderFactory.createXMLReader();
        xmlreader.setContentHandler(super.xmlConsumer);
        InputSource source = new InputSource(new StringReader(xml.toString()));
        xmlreader.parse(source);
        try {
            this.finalize();
        } catch (Throwable e) {
        }
    }

}