package node.xom;

import java.util.Collections;
import java.util.List;

import node.WrappedNode;
import nu.xom.Document;
import nu.xom.Element;

public class WrappedDocument implements WrappedNode {
  private final Document d;

  public WrappedDocument(Document d) {
    this.d = d;
  }

  @Override
  public List<WrappedElement> getChildElements(String namespaceUri, String localName) {
    Element root = d.getRootElement();
    if (isAt(root, namespaceUri, localName)) {
      return Collections.singletonList(new WrappedElement(root));
    }
    return Collections.emptyList();
  }

  @Override
  public WrappedAttribute getAttribute(String namespaceUri, String localName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getValue() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return d.toString();
  }

  private static boolean isAt(Element e, String namespaceUri, String localName) {
    return namespaceUri.equals(e.getNamespaceURI())
        && localName.equals(e.getLocalName());
  }
}