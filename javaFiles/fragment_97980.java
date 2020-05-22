final DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
documentBuilder.setEntityResolver(new EntityResolver2() {
    @Override
    public InputSource getExternalSubset(String string, String string1) throws SAXException, IOException {
        return null;
    }

    @Override
    public InputSource resolveEntity(String string, String string1, String string2, String string3) throws SAXException, IOException {
        final String resourceName = string3;
        final InputSource is = new InputSource();
        is.setSystemId(resourceName);
        is.setByteStream(Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName));
        return is;
    }


    @Override
    public InputSource resolveEntity(String string, String string1) throws SAXException, IOException {
        return null;
    }
});