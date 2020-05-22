private static void parseXML(File f) throws IOException, ParserConfigurationException, SAXException {
    StringBuilder xml = new StringBuilder();
    try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f),
                                                                      StandardCharsets.UTF_8))) {
        Pattern badChars = Pattern.compile("[^\\u0009\\u000a\\u000d\\u0020-\\uD7FF\\uE000-\\uFFFD]+");
        char[] cbuf = new char[1024];
        for (int len; (len = in.read(cbuf)) != -1; )
            xml.append(badChars.matcher(CharBuffer.wrap(cbuf, 0, len)).replaceAll(""));
    }
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domFactory.newDocumentBuilder();
    Document document = domBuilder.parse(new InputSource(new StringReader(xml.toString())));
    // insert code using DOM here
}