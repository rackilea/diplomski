String base64;
try (InputStream is = YourClass.class.getResourceAsStream(pathToYourFile)) {
    byte bytes[] = IOUtils.toByteArray(is);
    base64 = Base64.getEncoder().encodeToString(bytes);
}

IndexRequest indexRequest = new IndexRequest("index", "type", "id")
   .setPipeline("foo")
   .source(
       jsonBuilder().startObject()
           .field("field", base64)
       .endObject()
   );