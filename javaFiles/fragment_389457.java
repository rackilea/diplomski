public class GenericXMLParserSAX extends DefaultHandler {

    private ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
    String tempCharacter;   
    private String[] startElements;
    private String[] endElements;

    public void setStartElements(String[] startElements) {
            this.startElements = startElements;
    }

    public String[] getStartElements() {
            return startElements;
    }

    public void setEndElements(String[] endElements) {
            this.endElements = endElements;
    }

    public String[] getEndElements() {
            return endElements;
    }

    public void parseDocument(String xml, String[] startElements, String[] endElements) {
            setStartElements(startElements);
            setEndElements(endElements);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            try {
                    SAXParser sp = spf.newSAXParser();                      
                    InputStream inputStream = new ByteArrayInputStream(xml.getBytes());                     
                    sp.parse(inputStream, this);
            } catch(SAXException se) {
                    se.printStackTrace();
            } catch(ParserConfigurationException pce) {
                    pce.printStackTrace();
            } catch (IOException ie) {
                    ie.printStackTrace();
            }
    }

    public void parseDocument(String xml, String[] endElements) {           
            setEndElements(endElements);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            try {
                    SAXParser sp = spf.newSAXParser();                      
                    InputStream inputStream = new ByteArrayInputStream(xml.getBytes());                     
                    sp.parse(inputStream, this);
            } catch(SAXException se) {
                    se.printStackTrace();
            } catch(ParserConfigurationException pce) {
                    pce.printStackTrace();
            } catch (IOException ie) {
                    ie.printStackTrace();
            }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String[] startElements = getStartElements();

            if(startElements!= null){
                    for(int i = 0; i < startElements.length; i++) {
                            if(qName.startsWith(startElements[i])) {                                
                                    listMultimap.put(startElements[i], qName);
                            }
                    }       
            }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
            tempCharacter = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {                
            String[] endElements = getEndElements();

            for(int i = 0; i < endElements.length; i++) {
                    if (qName.equalsIgnoreCase(endElements[i])) {
                            listMultimap.put(endElements[i], tempCharacter);                
                    }
            }
    }

    public ListMultimap<String, String> multiSetResult() {            
            return listMultimap;
    }
}