protected XStream createXStream() {
  XStream xs = new XStream();
  // ...
  xs.registerConverter(...);
  return xs;
}