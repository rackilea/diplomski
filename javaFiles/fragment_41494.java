//keep a reference to MyHandler
MyHandler handler = new MyHandler();

XMLReader parser = XMLReaderFactory.createXMLReader();

parser.setContentHandler(handler);

parser.parse(mySource);

//get your results
List<String> rules = handler.getRules();