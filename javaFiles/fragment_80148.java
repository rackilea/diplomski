import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Test {
   public static void main(String[] args) throws Exception {
       DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       InputSource is = new InputSource();
       is.setCharacterStream(new StringReader("<root><node1></node1></root>"));
       Document doc = (Document) db.parse(is);  
   }
}