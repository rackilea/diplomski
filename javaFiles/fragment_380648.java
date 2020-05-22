import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String args[]){
        final String MIMETYPE = "application/vnd.oasis.opendocument.spreadsheet";
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.newDocument();
            Element e = null;

            String namespace = "urn:oasis:names:tc:opendocument:xmlns:manifest:1.0";

            Element rootEle = dom.createElementNS(namespace, "manifest:manifest");
            rootEle.setAttributeNS(namespace, "manifest:version","1.2");

            e = dom.createElementNS(namespace, "manifest:file-entry");
            e.setAttributeNS(namespace, "manifest:full-path","/");
            e.setAttributeNS(namespace, "manifest:version","1.2");
            e.setAttributeNS(namespace, "manifest:media-type",MIMETYPE);
            rootEle.appendChild(e);

            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                FileOutputStream o = new FileOutputStream("Output.xml");
                tr.transform(new DOMSource(dom), new StreamResult(o));

                o.close();
            } catch (TransformerException te) {
                System.err.println(te.getMessage());
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.err.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}