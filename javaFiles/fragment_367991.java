...
ByteArrayOutputStream os = new ByteArrayOutputStream();
jaxbMarshaller.marshal(test, os);

StringBuffer content = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
content.append(os.toString());
System.out.println("jaxb xml = " + os.toString());

response.setContentType("text/plain");
response.setHeader("Content-Disposition", "attachment;filename=xmlTest.xml");

String generatedXML = content.toString();
System.out.println("full xml = " + generatedXML);
InputStream is = new ByteArrayInputStream(generatedXML);

final int bufferSize = 4096;
OutputStream output = new BufferedOutputStream(response.getOutputStream(), bufferSize);
for (int length = 0; (length = is.read(buffer)) > 0;) {
  output.write(buffer, 0, length);
}
output.flush();
output.close();