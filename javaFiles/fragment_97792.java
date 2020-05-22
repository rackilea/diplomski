URL url = new URL("...");
InputStream in = new BufferedInputStream(url.openStream());
ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
int c = 0;
while((c = in.read()) >= 0) {
  buffer1.write(c);
}

System.out.println(String.format("Length in Bytes: %d", 
    buffer1.toByteArray().length));

ByteArrayInputStream buffer2 = new ByteArrayInputStream(buffer1.toByteArray());

Document doc = DocumentBuilderFactory.newInstance()
    .newDocumentBuilder().parse(buffer2);