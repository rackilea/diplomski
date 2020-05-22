SAXParserFactory factory = SAXParserFactory.newInstance();
SAXParser parser = factory.newSAXParser();

InputSource is = new InputSource(url);
is.setEncoding("ISO-8859-15");

DefaultHandler lxmlr=new LibraryXMLReader() ;
sp.parse(is, lxmlr);