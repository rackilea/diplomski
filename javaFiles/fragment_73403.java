com.sun.org.apache.xerces.internal.impl.xs.SubstitutionGroupHandler:

public XSElementDecl getMatchingElemDecl(QName element, XSElementDecl exemplar) {
    if (element.localpart == exemplar.fName &&
        element.uri == exemplar.fTargetNamespace) {
        return exemplar;
    }
    ...
}