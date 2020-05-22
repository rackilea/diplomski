// output stream
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
// transcode
StringReader xml = new StringReader("<x>pi: \u03A0</x>");
XMLEventReader reader = XMLInputFactory.newFactory().createXMLEventReader(
    xml);
XMLEventWriter writer = XMLOutputFactory.newFactory().createXMLEventWriter(
    buffer, "ISO-8859-1");
try {
  writer.add(reader);
} finally {
  writer.close();
}
// proof
String decoded = new String(buffer.toByteArray(),
    Charset.forName("ISO-8859-1"));
System.out.println(decoded);