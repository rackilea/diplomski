Namespace sig = Namespace.getNamespace("sig", "http://www.w3.org/2000/09/xmldsig#");
Namespace nfe = Namespace.getNamespace("nfe", "http://www.portalfiscal.inf.br/nfe");

XPathFactory xfac = XPathFactory.instance();
XPathExpression<Element> digest = xfac.compile(
    "/nfe:enviNFe/nfe:NFe/sig:Signature/sig:SignedInfo/sig:Reference/sig:DigestValue",
    Filters.element(), null, sig, nfe);

String digestValue = digest.evaluateFirst().value();