import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public void getCDATAFromHardcodedPathWithStax() {
    String yourSampleFile = "/path/toYour/sample/file.xml";
    String cdataNode = "extendedinfo";
    XMLStreamReader r = null;
    try (InputStream in =
            new BufferedInputStream(new FileInputStream(yourSampleFile));)        {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        r = factory.createXMLStreamReader(in);
        while (r.hasNext()) {
            switch (r.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
                if (cdataNode.equals(r.getName().getLocalPart())) {
                    System.out.println(r.getElementText());
                }
                break;
            default:
                break;
            }
            r.next();
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    } finally {
        if (r != null) {
            try {
                r.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}