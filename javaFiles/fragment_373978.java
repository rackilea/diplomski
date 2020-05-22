...
InputStream elementIS = getInputStreamFromElement(soapEnvelope);
retClob = setCharacterStream(elementIS, retClob);

return retClob;

public static InputStream getInputStreamFromElement(Element element) throws Exception {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Source xmlSource = new DOMSource(element);
    Result outputTarget = new StreamResult(outputStream);
    TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
    InputStream is = new ByteArrayInputStream(outputStream.toByteArray());

    return is;
}

public static Clob setCharacterStream(InputStream inputStream, Clob clob) throws Exception{
    DOMParser parser = new DOMParser();
    parser.parse(inputStream);
    XMLDocument xmlDocument = parser.getDocument();
    XMLElement xmlPayload = (XMLElement) xmlDocument.getDocumentElement();
    Writer writer = clob.setCharacterStream(1);
    xmlPayload.print(writer);

    return clob;
}