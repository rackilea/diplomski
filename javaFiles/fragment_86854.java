public class IndentingStaxEventItemWriter <T> extends StaxEventItemWriter<T> {

      private boolean indenting = true;

      @Override
      protected XMLEventWriter createXmlEventWriter( XMLOutputFactory outputFactory, Writer writer) throws XMLStreamException {
        if (indenting) {
          return new IndentingXMLEventWriter( super.createXmlEventWriter( outputFactory, writer ) );
        }
        else {
          return super.createXmlEventWriter( outputFactory, writer );
        }
      }

    public boolean isIndenting() {
        return indenting;
    }

    public void setIndenting(boolean indenting) {
        this.indenting = indenting;
    }

}