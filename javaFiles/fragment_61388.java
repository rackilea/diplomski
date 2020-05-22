@Override
public List<String> getCustomizationURIs() {
    List<String> uris = new ArrayList<>();
    uris.add(...);
    return uris;
}

@Override
public boolean isCustomizationTagName(String nsUri, String localName) {
    return ...;
}


for (CPluginCustomization customization : propertyInfo.getCustomizations()) {
    if (isCustomizationTagName(customization.element.getNamespaceURI(),
            customization.element.getLocalName())) {
        // Apply the customization.
        ...

        // Tell XJC that the customization was consumed.
        customization.markAsAcknowledged();
    }
}