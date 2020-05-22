byte[] source = ...;
ByteArrayInputStream bis = new ByteArrayInputStream(source);
// read bytes from bis ...

ByteArrayOutputStream bos = new ByteArrayOutputStream();
// write bytes to bos ...
byte[] sink = bos.toByteArray();