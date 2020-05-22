package reorder.xsom;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class UncheckedXMLStreamWriter {
  private final XMLStreamWriter real;

  public UncheckedXMLStreamWriter(XMLStreamWriter delegate) {
    this.real = delegate;
  }

  public void writeStartElement(String namespaceUri, String localName) {
    try {
      real.writeStartElement(namespaceUri, localName);
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeEndElement() {
    try {
      real.writeEndElement();
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
  }

  public  void writeAttribute(String namespaceUri, String localName, String value) {
    try {
      real.writeAttribute(namespaceUri, localName, value);
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeCharacters(String value) {
    try {
      real.writeCharacters(value);
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
  }
}