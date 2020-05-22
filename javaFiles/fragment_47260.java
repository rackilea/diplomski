// output stream
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
// transformation
StreamSource src = new StreamSource(new StringReader("<x>pi: \u03A0</x>"));
StreamResult res = new StreamResult(buffer);
Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
transformer.transform(src, res);
// proof
String decoded = new String(buffer.toByteArray(),
    Charset.forName("ISO-8859-1"));
System.out.println(decoded);