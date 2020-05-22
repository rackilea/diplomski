String pdfUUID = "put-uuid-here";
Node pdfNode = session.getNodeByIdentifier(pdfUUID);
Node jcrContent = pdfNode.getNode("jcr:content");
Property dataProperty = jcrContent.getProperty("jcr:data");
Binary dataBinary = dataProperty.getBinary();
InputStream dataInputStream = dataBinary.getStream();
//do something
dataInputStream.close();
dataBinary.dispose();