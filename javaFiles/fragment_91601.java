import org.w3c.dom.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.*;

public class DOMExample3 {

    public static void main(String[] args) throws Exception {
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();    
        DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
        if (impl == null) {
            System.out.println("No DOMImplementation found !");
            System.exit(0);
        }

        System.out.printf("DOMImplementationLS: %s\n", impl.getClass().getName());

        LSParser parser = impl.createLSParser(
                DOMImplementationLS.MODE_SYNCHRONOUS,
                "http://www.w3.org/TR/REC-xml");
        // http://www.w3.org/2001/XMLSchema
        System.out.printf("LSParser: %s\n", parser.getClass().getName());

        if (args.length == 0) {
            System.exit(0);
        }

        Document doc = parser.parseURI(args[0]);

        LSSerializer serializer = impl.createLSSerializer();
        LSOutput output = impl.createLSOutput();
        output.setEncoding("UTF-8");
        output.setByteStream(System.out);
        serializer.write(doc, output);
        System.out.println();
    }
}