@Override
public DocumentBuilder newDocumentBuilder()
        throws ParserConfigurationException {
    if (isValidating()) {
        throw new ParserConfigurationException(
                "No validating DocumentBuilder implementation available");
    }

    /**
     * TODO If Android is going to support a different DocumentBuilder
     * implementations, this should be wired here. If we wanted to
     * allow different implementations, these could be distinguished by
     * a special feature (like http://www.org.apache.harmony.com/xml/expat)
     * or by throwing the full SPI monty at it.
     */
    DocumentBuilderImpl builder = new DocumentBuilderImpl();
    builder.setCoalescing(isCoalescing());
    builder.setIgnoreComments(isIgnoringComments());
    builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
    builder.setNamespaceAware(isNamespaceAware());

    // TODO What about expandEntityReferences?

    return builder;
}