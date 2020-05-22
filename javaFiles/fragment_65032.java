// Initialize the library
DefaultBootstrap.bootstrap(); 

// Get parser pool manager
BasicParserPool ppMgr = new BasicParserPool();
ppMgr.setNamespaceAware(true);

// Get org.w3c.dom.Document Object from response
HttpURLConnection req = (HttpURLConnection) new URL("<saml-xml-url>").openConnection();
// Add some necessary headers for the request
// req.addRequestProperty("...", "...");
// ...
InputStream in = req.getInputStream();
Document inCommonMDDoc = ppMgr.parse(in);

// Get the DOMSource from org.w3c.dom.Document Object
DOMSource domSource=new DOMSource(document);  

//Add an extension schema via the code SAMLSchemaBuilder.addExtensionSchema(String schema) if necessary
Schema schema = SAMLSchemaBuilder.getSAML11Schema();

// Get a Validator instance.
Validator validator = schema.newValidator();
try {
    validator.validate(domSource);
    System.out.println("Result : Valid!");
} catch(Exception e) {
    System.out.println("Result : Invalid!");
}