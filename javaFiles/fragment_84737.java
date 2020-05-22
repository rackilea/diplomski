public class StreamSerializer extends Serializer {

    public StreamSerializer(OutputStream out) {
        super(out);
    }

    @Override
    public void write(Element element) throws IOException {
        super.write(element);
    }

    @Override
    public void writeXMLDeclaration() throws IOException {
        super.writeXMLDeclaration();
    }

    @Override
    public void writeEndTag(Element element) throws IOException {
        super.writeEndTag(element);
    }

    @Override
    public void writeStartTag(Element element) throws IOException {
        super.writeStartTag(element);
    }

}