public static class DTDReplacer extends
      EventReaderDelegate {

    private final XMLEvent dtd;
    private boolean sendDtd = false;

    public DTDReplacer(XMLEventReader reader, XMLEvent dtd) {
      super(reader);
      if (dtd.getEventType() != XMLEvent.DTD) {
        throw new IllegalArgumentException("" + dtd);
      }
      this.dtd = dtd;
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
      if (sendDtd) {
        sendDtd = false;
        return dtd;
      }
      XMLEvent evt = super.nextEvent();
      if (evt.getEventType() == XMLEvent.START_DOCUMENT) {
        sendDtd = true;
      } else if (evt.getEventType() == XMLEvent.DTD) {
        // discard old DTD
        return super.nextEvent();
      }
      return evt;
    }

  }