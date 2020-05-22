public XMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier)
        throws XNIException, IOException {

    String resolvedId = resolveIdentifier(resourceIdentifier);

    if (resolvedId != null) {
        XMLInputSource xmlis = new XMLInputSource(resourceIdentifier.getPublicId(),
                resolvedId,
                resourceIdentifier.getBaseSystemId());

        try {
            InputStream is = getXSDFromDb(resourceIdentifier.getLiteralSystemId());                
            xmlis.setByteStream(is);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return xmlis;
    }
    return null;