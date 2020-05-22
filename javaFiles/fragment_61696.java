import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlTest
{

    public static void main(String[] args) throws Exception
    {
        InputStream is = new FileInputStream("test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document oldDoc = builder.parse(is);
        Node oldRoot = oldDoc.getDocumentElement();
        Document newDoc = builder.newDocument();
        Element newRoot = newDoc.createElement("newroot");
        newDoc.appendChild(newRoot);
        newRoot.appendChild(newDoc.importNode(oldRoot, true));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(newDoc);
        Writer writer = new OutputStreamWriter(out);
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        writer.flush();

        InputStream isNewXML = new ByteArrayInputStream(out.toByteArray());

    }

}