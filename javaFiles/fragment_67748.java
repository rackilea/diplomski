FileOutputStream output = new FileOutputStream(fileName);
try {
  Writer writer = new OutputStreamWriter(new GZIPOutputStream(output), "UTF-8");
  try {
    writer.write(text);
  } finally {
    writer.close();
  }
 } finally {
   output.close();
 }