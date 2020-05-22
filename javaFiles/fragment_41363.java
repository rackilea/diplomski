private static NamespaceContext getNamespaceContext() {
    NamespaceContext namespaceContext = new NamespaceContext() {
        public String getNamespaceURI(String prefix) {
            String uri = null;
            if (prefix == null) {
                throw new IllegalArgumentException("No prefix provided!");
            } else if(prefix.equals("m")) {
                uri = "http://oasis.caiso.com/mrtu-oasis/xsd/OASISReport.xsd";
            }
            return uri;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public Iterator getPrefixes(String namespaceURI) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getPrefix(String namespaceURI) {
            // TODO Auto-generated method stub
            return null;
        }
    };

    return namespaceContext;
}