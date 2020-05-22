marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
                @Override
                public String[] getPreDeclaredNamespaceUris() {
                    return new String[] { 
                        XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI
                    };
                }

                @Override
                public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
                    if (namespaceUri.equals(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI))
                        return "xsi";
                    if (namespaceUri.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI))
                        return "xs";
                    if (namespaceUri.equals(WellKnownNamespace.XML_MIME_URI))
                        return "xmime";
                    return suggestion;

                }
            });