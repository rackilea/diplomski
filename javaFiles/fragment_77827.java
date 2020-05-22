NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return "";
    }
};
marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);