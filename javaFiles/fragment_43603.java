InputStream entityIn = requestContext.getEntityStream();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
// write `entityIn` to `baos`
byte[] bytes = baos.toByteArray();
POJO pojo = new ObjectMapper().readValue(bytes, POJO.class);
// do something with POJO
requestContext.setEntityStream(new ByteArrayInputStream(bytes));