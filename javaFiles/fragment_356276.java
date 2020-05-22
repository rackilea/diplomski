import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://website.com/document.pdf");
        ContentHandler contenthandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(is, contenthandler, metadata, new ParseContext());

        System.out.println(contenthandler.toString());
    }
}