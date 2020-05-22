DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setValidating(false);
factory.setNamespaceAware(true);

DocumentBuilder builder = factory.newDocumentBuilder();

builder.setErrorHandler(new SimpleErrorHandler());    
// the "parse" method also validates XML, will throw an exception if misformatted
Document document = builder.parse(new InputSource("document.xml"));