public class DelegatingHandler extends DefaultHandler {

    private Map<String, DefaultHandler> saxHandlers;
    private DefaultHandler delegate = null;

    public DelegatingHandler(Map<String, DefaultHandler> delegates) {
        saxHandlers = delegates;
    }

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {
       if(delegate == null) {
           delegate = saxHandlers.get(name);
       }
       delegate.startElement(uri, localName, name, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        delegate.endElement(uri, localName, name);
    }

//etcetera...