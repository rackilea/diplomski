package node.xom;

import java.util.List;

import node.WrappedNode;
import nu.xom.Attribute;

class WrappedAttribute implements WrappedNode {
  private final Attribute a;

  WrappedAttribute(Attribute a) {
    this.a = a;
  }

  @Override
  public List<WrappedNode> getChildElements(String namespaceUri, String localName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public WrappedNode getAttribute(String namespaceUri, String localName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getValue() {
    return a.getValue();
  }

  @Override
  public String toString() {
    return a.toString();
  }
}