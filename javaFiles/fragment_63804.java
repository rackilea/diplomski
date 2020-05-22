String text;
InputStreamReader reader = new InputStreamReader(supplier.get(), 
    Charsets.UTF_8);
boolean threw = true;
try {
  text = CharStreams.toString(reader);
  threw = false;
}
finally {
  Closeables.close(reader, threw);
}