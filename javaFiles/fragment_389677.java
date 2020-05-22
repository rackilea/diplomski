public class SomeObjectsIterableParser implements Iterable<SomeObjectType> {

  private final Unmarshaller jaxbUnmarshaller;
  private final XMLStreamReader xmlReader;

  public SomeObjectsIterableParser(Schema schema, Reader SomeObjectResponse) throws ExtractorException {
    try {
      jaxbUnmarshaller = JAXBContext.newInstance(SomeObjectType.class).createUnmarshaller();
      xmlReader = XMLInputFactory.newFactory().createXMLStreamReader(SomeObjectResponse);
    } catch (JAXBException | XMLStreamException e) {
      throw new ExtractorException("Could not create jaxbUnmarshaller", e);
    }
    //jaxbUnmarshaller.setSchema(schema); //schema can handle only root element
    advanceReaderToFirstProfile();
  }

  private void advanceReaderToFirstProfile() {
    try {
      xmlReader.nextTag();
      while(!xmlReader.getLocalName().equals("SomeObject")) {
        xmlReader.nextTag();
      }
    } catch (XMLStreamException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Iterator<SomeObjectType> iterator() {
    return new MyIterator();
  }

  class MyIterator implements Iterator<SomeObjectType> {

    @Override
    public boolean hasNext() {
      try {
        if (xmlReader.isWhiteSpace() && xmlReader.hasNext()) {
          //ommit witespaces
          xmlReader.nextTag();
        }
      } catch (XMLStreamException e) {
        throw new RuntimeException(e);
      }
      return xmlReader.isStartElement() 
          && xmlReader.getLocalName().equals("SomeObject");
    }

    @Override
    public SomeObjectType next() {
      try {
        JAXBElement<SomeObjectType> element = jaxbUnmarshaller.unmarshal(xmlReader, SomeObjectType.class);
        return element.getValue();
      } catch (JAXBException | XMLStreamException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported yet");
    }
  }
}