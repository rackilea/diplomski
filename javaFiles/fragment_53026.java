InputStream textReader = new ByteArrayInputStream ( myByteArray);
SAXParserFactory parserFactory = SAXParserFactory.newInstance();
try {
        XMLReader reader = parserFactory.newSAXParser().getXMLReader();
        reader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        InputSource inputSource = new InputSource( textReader );
        reader.parse(inputSource);
}