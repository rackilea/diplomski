URL schemaFile = new URL(strSchemaLocation);
HttpsURLConnection schemaConn = (HttpsURLConnection)schemaFile.openConnection();
// Magic from the other answer to accept self-signed cert
InputStream is = schemaConn.getInputStream();
SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = schemaFactory.newSchema(new StreamSource(is));