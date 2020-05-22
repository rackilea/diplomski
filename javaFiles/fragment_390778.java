package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import node.xom.WrappedDocument;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import reorder.xsom.UncheckedXMLStreamWriter;
import reorder.xsom.XSVisitorWriteOrdered;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.parser.XSOMParser;

public class ReorderXmlToXsd {
  public static void main(String[] args) throws Exception {
    File unorderedXml = new File("unordered.xml");
    File xsd = new File("your.xsd");
    File orderedXml = new File("ordered.xml");

    XSOMParser p = new XSOMParser();
    p.parse(xsd);
    XSSchemaSet parsed = p.getResult();

    Builder xom = new Builder();
    Document unorderedDoc = xom.build(unorderedXml);
    Element unorderedRoot = unorderedDoc.getRootElement();

    XSElementDecl root = parsed.getElementDecl(
        unorderedRoot.getNamespaceURI(),
        unorderedRoot.getLocalName());

    XMLOutputFactory stax = XMLOutputFactory.newInstance();

    try (OutputStream to = new FileOutputStream(orderedXml)) {
      XMLStreamWriter using = stax.createXMLStreamWriter(to, "UTF-8");

      root.visit(
          new XSVisitorWriteOrdered(
              new WrappedDocument(unorderedDoc),
              new UncheckedXMLStreamWriter(using)));
    }
  }
}