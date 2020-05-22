class CustomUnmapped extends org.eclipse.persistence.internal.oxm.unmapped.DefaultUnmappedContentHandler {
    @Override
    public void startElement(String p1, String p2, String p3, Attributes p4) throws SAXException {
        throw new SAXNotRecognizedException(p1);
    }
}