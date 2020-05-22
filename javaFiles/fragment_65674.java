class ContentFinder implements StreamFilter {
    private boolean capture = false;

    @Override
    public boolean accept(XMLStreamReader xml) {
      if (xml.isStartElement() && "book".equals(xml.getLocalName())) {
        capture = true;
      } else if (xml.isEndElement() && "book".equals(xml.getLocalName())) {
        capture = false;
        return true;
      }
      return capture;
    }
  }

  class Limiter extends StreamReaderDelegate {
    Limiter(XMLStreamReader xml) {
      super(xml);
    }

    @Override
    public boolean hasNext() throws XMLStreamException {
      return !(getParent().isEndElement()
               && "book".equals(getParent().getLocalName()));
    }
  }