import java.io.BufferedInputStream;
    import java.io.FileInputStream;
    import java.io.InputStream;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import org.w3c.dom.Document;
    import org.w3c.dom.Node;
    import org.w3c.dom.NodeList;

public void getCDATAFromHardcodedPathWithDom() {
    String yourSampleFile = "/path/toYour/sample/file.xml";
    String cdataNode = "extendedinfo";
    try (InputStream in =
            new BufferedInputStream(new FileInputStream(yourSampleFile))) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(in);
        NodeList elements = doc.getElementsByTagName(cdataNode);
        for (int i = 0; i < elements.getLength(); i++) {
            Node e = elements.item(i);
            System.out.println(e.getTextContent());
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}