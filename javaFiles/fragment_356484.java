SAXParserFactory spf = SAXParserFactory.newInstance();
spf.setNamespaceAware(true);
XMLReader reader = spf.newSAXParser().getXMLReader();

String FEATURE ="";

// disallow DOCTYPE
FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
reader.setFeature(FEATURE, true);

//forbid external Entity 
FEATURE ="http://xml.org/sax/features/external-general-entities";
reader.setFeature(FEATURE, false);

//forbid external parameters
FEATURE ="http://xml.org/sax/features/external-parameter-entities";
reader.setFeature(FEATURE, false);

SAXSource saxSource = new SAXSource(reader, new InputSource(inputStream));

Validator validator = xmlSchema.newValidator();

validator.validate(saxSource);