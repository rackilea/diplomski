DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder db = factory.newDocumentBuilder();

//parse file into DOM
Document doc = db.parse(new File("file.xml"));
DOMSource source = new DOMSource(doc);

//now use a transformer to add the DTD element
TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "/path/to/file.dtd");
StringWriter writer = new StringWriter();
StreamResult result = new StreamResult(writer);
transformer.transform(source, result);

//finally parse the result. 
//this will throw an exception if the doc is invalid
db.parse(new InputSource(new StringReader(writer.toString())));