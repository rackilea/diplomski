DocumentBuilder b = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document document = b.parse(...);

// Parent of existing Block elements and new Address elemet
// Might be retrieved differently depending on 
// actual structure
Element parent = document.getDocumentElement();
Element address = document.createElement("address");

NodeList nl = parent.getElementsByTagName("Block");
for (int i = 0; i < nl.getLength(); ++i) {
    Element block = (Element) nl.item(i);
    if (i == 0)
        parent.insertBefore(address, block);
    parent.removeChild(block);
    address.appendChild(block);
}

// UPDATE: how to pretty print

LSSerializer serializer = 
    ((DOMImplementationLS)document.getImplementation()).createLSSerializer();
serializer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
LSOutput output = 
    ((DOMImplementationLS)document.getImplementation()).createLSOutput();
output.setByteStream(System.out);
serializer.write(document, output);