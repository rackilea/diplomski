InputStream in = ...
Reader reader = new InputStreamReader(in, "Shift_JIS");
StringBuilder sb = new StringBuilder();
int read;
while ((read = reader.read()) != -1){
  sb.append((char)read);
}
reader.close();

String string = sb.toString();

OutputStream out = ...
Writer writer = new OutputStreamWriter(out, "UTF-8");
writer.write(string);
writer.close();