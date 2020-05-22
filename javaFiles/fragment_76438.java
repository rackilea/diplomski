final URL myUrl= new URL("http://www.example.com/file.xml");
final InputStream in= myUrl.openStream();

final StringBuilder out = new StringBuilder();
final byte[] buffer = new byte[BUFFER_SIZE_WHY_NOT_1024];

try {
   for (int ctr; (ctr = in.read(buffer)) != -1;) {
       out.append(new String(buffer, 0, ctr));
   }
} catch (IOException e) {
   // you may want to handle the Exception. Here this is just an example:
   throw new RuntimeException("Cannot convert stream to string", e);
}

final String yourFileAsAString = out.toString();