import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.batik.apps.rasterizer.DestinationType;
import org.apache.batik.apps.rasterizer.SVGConverter;
import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;


public class DOMRasterizer {

public Document createDocument(InputStream in) {
    Document doc = null ;
    try {
        // Create a new svg document.
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        doc = f.createSVGDocument(null, in);

    } catch (IOException ex) {
        Logger.getLogger(DOMRasterizer.class.getName()).log(Level.SEVERE, null, ex);
    }
    return doc;
}

public static void main(String[] args) throws Exception {

    DOMRasterizer rasterizer = new DOMRasterizer();
    InputStream in = new FileInputStream(new File("your svg path"));
    Document svgXmlDoc = rasterizer.createDocument(in);

    // Save this SVG into a file (required by SVG -> PNG transformation process)
    File svgFile = File.createTempFile("graphic-", ".svg");
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource source = new DOMSource(svgXmlDoc);
    FileOutputStream fos = new FileOutputStream(svgFile);
    try {
        transformer.transform(source, new StreamResult(fos));
    } finally {
        fos.close();
    }
    // Convert the SVG into PNG
    File outputFile =new File("output path");
    SVGConverter converter = new SVGConverter();
    converter.setDestinationType(DestinationType.PNG);
    converter.setSources(new String[]{svgFile.toString()});
    converter.setDst(outputFile);
    converter.execute();
}
}