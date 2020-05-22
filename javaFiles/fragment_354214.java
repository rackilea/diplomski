import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class RegexTest {
    private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public static void main(String[] args) throws Exception {
        RegexTest domTest = new RegexTest();
        domTest.testXmlDocumentWithNamespaces();
    }

    public void testXmlDocumentWithNamespaces() throws Exception {
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation domImpl = db.getDOMImplementation();
        Document document = addNameSpaces(domImpl);
        serialize(domImpl, document);
    }

    private Document addNameSpaces(DOMImplementation domImpl) {
        Document document = domImpl.createDocument("http://company/configuration", "cfg:configuration", null);
        document.getDocumentElement().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:ContentRouter", "http://company/ContentRouter-3.0");
        document.getDocumentElement().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xs", "http://www.w3.org/2001/XMLSchema");
        document.getDocumentElement().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

        return document;
    }

    private void serialize(DOMImplementation domImpl, Document document) {
        DOMImplementationLS ls = (DOMImplementationLS) domImpl;
        LSSerializer lss = ls.createLSSerializer();
        LSOutput lso = ls.createLSOutput();
        lso.setByteStream(System.out);
        lss.write(document, lso);
    }

}