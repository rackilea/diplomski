package reorder.xsom;

import node.WrappedNode;

import com.sun.xml.xsom.*;
import com.sun.xml.xsom.visitor.XSVisitor;

public class XSVisitorWriteOrdered implements XSVisitor {
  private final WrappedNode currNode;
  private final UncheckedXMLStreamWriter writeTo;

  public XSVisitorWriteOrdered(WrappedNode currNode, UncheckedXMLStreamWriter writeTo) {
    this.currNode = currNode;
    this.writeTo = writeTo;
  }

  @Override
  public void attributeUse(XSAttributeUse use) {
    attributeDecl(use.getDecl());
  }

  @Override
  public void modelGroupDecl(XSModelGroupDecl decl) {
    modelGroup(decl.getModelGroup());
  }

  @Override
  public void modelGroup(XSModelGroup model) {
    for (XSParticle term : model.getChildren()) {
      term.visit(this);
    }
  }

  @Override
  public void particle(XSParticle particle) {
    XSTerm term = particle.getTerm();
    term.visit(this);
  }

  @Override
  public void complexType(XSComplexType complex) {
    for (XSAttributeUse use : complex.getAttributeUses()) {
      attributeUse(use);
    }

    XSContentType contentType = complex.getContentType();
    contentType.visit(this);
  }

  @Override
  public void elementDecl(XSElementDecl decl) {
    String namespaceUri = decl.getTargetNamespace();
    String localName = decl.getName();

    for (WrappedNode child : currNode.getChildElements(namespaceUri, localName)) {
      writeTo.writeStartElement(namespaceUri, localName);

      XSType type = decl.getType();
      type.visit(new XSVisitorWriteOrdered(child, writeTo));

      writeTo.writeEndElement();
    }
  }

  @Override
  public void attributeDecl(XSAttributeDecl decl) {
    String namespaceUri = decl.getTargetNamespace();
    String localName = decl.getName();

    WrappedNode attribute = currNode.getAttribute(namespaceUri, localName);
    if (attribute != null) {
      String value = attribute.getValue();
      if (value != null) {
        writeTo.writeAttribute(namespaceUri, localName, value);
      }
    }
  }

  @Override
  public void simpleType(XSSimpleType simpleType) {
    String value = currNode.getValue();
    if (value != null) {
      writeTo.writeCharacters(value);
    }
  }

  @Override
  public void empty(XSContentType empty) {}

  @Override
  public void facet(XSFacet facet) {}

  @Override
  public void annotation(XSAnnotation ann) {}

  @Override
  public void schema(XSSchema schema) {}

  @Override
  public void notation(XSNotation notation) {}

  @Override
  public void identityConstraint(XSIdentityConstraint decl) {}

  @Override
  public void xpath(XSXPath xp) {}

  @Override
  public void wildcard(XSWildcard wc) {}

  @Override
  public void attGroupDecl(XSAttGroupDecl decl) {}
}