if (docPropertiesMap != null) {
    IDocProperty[] docProperties = new IDocProperty[docPropertiesMap.size()];
    int iArrIndex = 0;

    for (Map.Entry<String, String[]> entry : docPropertiesMap.entrySet()) {
        String strPropName = entry.getKey();
        String[] propValue = entry.getValue();

        IDocProperty docProperty = (IDocProperty) FDMAFactory.getDataObject("DocProperty");
        docProperty.setPropertyName(strPropName);
        docProperty.setArrPropertyValues(propValue);
        docProperties[iArrIndex++] = docProperty;
    }
    metadata.setArrDocProperties(docProperties);
    return metadata;
}