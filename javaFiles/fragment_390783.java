package node.xom;

import java.util.AbstractList;
import java.util.List;

import node.WrappedNode;
import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Elements;

class WrappedElement implements WrappedNode {
  private final Element e;

  WrappedElement(Element e) {
    this.e = e;
  }

  @Override
  public List<WrappedElement> getChildElements(String namespaceUri, String localName) {
    return asList(e.getChildElements(localName, namespaceUri));
  }

  @Override
  public WrappedAttribute getAttribute(String namespaceUri, String localName) {
    Attribute attribute = e.getAttribute(localName, namespaceUri);
    return (attribute != null) ? new WrappedAttribute(attribute) : null;
  }

  @Override
  public String getValue() {
    return e.getValue();
  }

  @Override
  public String toString() {
    return e.toString();
  }

  private static List<WrappedElement> asList(final Elements eles) {
    return new AbstractList<WrappedElement>() {
      @Override
      public WrappedElement get(int index) {
        return new WrappedElement(eles.get(index));
      }

      @Override
      public int size() {
        return eles.size();
      }
    };
  }
}