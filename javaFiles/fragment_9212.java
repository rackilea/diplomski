public String envelopeDocument_2_XSL(Document data) throws IOException, TransformerFactoryConfigurationError, TransformerException {
    URL xsltURL = getClass().getClassLoader().getResource("XSLT.xsl");
    Source stylesource = new StreamSource(xsltURL.openStream(), xsltURL.toExternalForm());

    Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);

    StringWriter stringWriter = new StringWriter();
    transformer.transform(new DOMSource(data), new StreamResult(stringWriter));

    return stringWriter.toString();
}