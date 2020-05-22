ByteArrayOutputStream baos = new ByteArrayOutputStream();
OutputStream os = new CompositeOutputStream(new DataOutputStream(...), baos);
os.write(...);
byte[] data = baos.toByteArray();
String dataAsString = new String(data, "UTF-8"); // or whatever encoding you are using
// etc.