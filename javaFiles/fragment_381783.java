xmlInput = XMLInputFactory.newInstance();
xmlInput.setXMLResolver(new XMLResolver() {
    @Override
    public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException {
        ...
        // Disable dtd validation
        if ("The public id you except".equals(publicId)) {
            return IOUtils.toInputStream("");
        }
        ...
    }
});