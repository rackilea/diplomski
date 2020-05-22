XMLReader xmlreader =
    SAXParserFactory.newInstance().newSAXParser().getXMLReader();
xmlreader.setContentHandler(new ContentHandler() {
    ...
});

xmlreader.parse(new InputSource(myInputStream));