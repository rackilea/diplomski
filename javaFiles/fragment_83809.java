int BUFFER_SIZE = 1024;
StringBuilder builder = new StringBuilder();
byte data[] = new byte[BUFFER_SIZE];
while(inputStream.available() > 0) {
   int read = inputStream.read(data);
   builder.append(new String(data, 0, read, "UTF-8"));
}
return builder.toString();