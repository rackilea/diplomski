DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = null;

builder = builderFactory.newDocumentBuilder();      
Document document = null;
byte[] bytes = Charset.forName("UTF-16LE").encode(xmlString).array();
InputStream inputStream = new ByteArrayInputStream(bytes);
document = builder.parse(inputStream);