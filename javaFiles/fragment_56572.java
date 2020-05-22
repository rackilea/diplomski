DOMImplementationLS domImplementationLS =
(DOMImplementationLS) dom.getImplementation().getFeature("LS","3.0");
LSOutput lsOutput = domImplementationLS.createLSOutput();
FileOutputStream outputStream = new FileOutputStream("output.xml");
lsOutput.setByteStream((OutputStream) outputStream);
LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
lsSerializer.write(dom, lsOutput);
outputStream.close();