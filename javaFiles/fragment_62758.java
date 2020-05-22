SAXParserFactory spf = SAXParserFactory.newInstance();
SAXParser sp = spf.newSAXParser();
XMLReader xr = sp.getXMLReader();
XMLHandler xh = new XMLHandler();

InputSource is = new InputSource();
is.setCharacterStream(new StringReader(xmlst));
xr.setContentHandler(xh);
xr.parse(new InputSource(is.getByteStream()));