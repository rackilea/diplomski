// output stream
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
// create XML DOM
InputSource src = new InputSource(new StringReader("<x>pi: \u03A0</x>"));
Document doc = DocumentBuilderFactory.newInstance()
    .newDocumentBuilder()
    .parse(src);
// serialize
DOMImplementationLS impl = (DOMImplementationLS) doc.getImplementation();
LSOutput out = impl.createLSOutput();
out.setEncoding("ISO-8859-1");
out.setByteStream(buffer);
impl.createLSSerializer().write(doc, out);
// proof
String decoded = new String(buffer.toByteArray(),
    Charset.forName("ISO-8859-1"));
System.out.println(decoded);