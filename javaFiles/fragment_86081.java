Unmarshaller unmarshaller = jc.createUnmarshaller();
InputStream inputStream = new FileInputStream("input.xml");
Reader reader = new InputStreamReader(inputStream, "UTF-8");
try {
    Address address = (Address) unmarshaller.unmarshal(reader);
} finally  {
    reader.close();
}