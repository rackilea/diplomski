DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
// stop the network loading of DTD files
factory.setValidating(false);
factory.setNamespaceAware(true);
factory.setFeature("http://xml.org/sax/features/namespaces", false);
factory.setFeature("http://xml.org/sax/features/validation", false);
factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
// open up the xml document
DocumentBuilder docbuilder = factory.newDocumentBuilder();
Document doc = docbuilder.parse(new FileInputStream(m_strFilePath));