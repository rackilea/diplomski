public String getAuthCodeResponse(String message) throws SAXException, IOException,     ParserConfigurationException {
factory = SAXParserFactory.newInstance();
handler = new SAXParserUsage(); // <--- You create local instance here
parser = factory.newSAXParser();
parser.parse(new InputSource(new StringReader(message)), handler);
// ^^ parser writes to local instance here but ...
return authorizationCode;
//    you return authCode field of the instance that this method is invoked on, 
//    which has not been changed by this method. 
//    So if it was null before, it still is null.
}