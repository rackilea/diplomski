Element rootElement = new Element("resultset");
StreamSerializer serializer = new StreamSerializer(out);
serializer.setIndent(4);
serializer.writeXMLDeclaration();
serializer.writeStartTag(rootElement);
while(hasNextElement()) {
    serializer.write(nextElement());
}
serializer.writeEndTag(rootElement);
serializer.flush();