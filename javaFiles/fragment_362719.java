XMLInputFactory f = XMLInputFactory.newInstance();
XMLStreamReader r = f.createXMLStreamReader("my.xml");
try {
  while (r.hasNext()) {
    r.next();
    . . .
  }
} finally {
  r.close()
}