public class SaxParserMain {

    /**
     * @param args
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        CustomHandler handler = new CustomHandler();
        parser.parse(new File("file/scxml.xml"), handler);
    }
}