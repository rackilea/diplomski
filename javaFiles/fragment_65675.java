XMLInputFactory inFactory = XMLInputFactory.newFactory();
XMLStreamReader reader = inFactory.createXMLStreamReader(inputStream);
reader = inFactory.createFilteredReader(reader, new ContentFinder());
Unmarshaller unmar = JAXBContext.newInstance(Book.class)
    .createUnmarshaller();
Transformer tformer = TransformerFactory.newInstance().newTransformer();
while (reader.hasNext()) {
  XMLStreamReader limiter = new Limiter(reader);
  Source src = new StAXSource(limiter);
  DOMResult res = new DOMResult();
  tformer.transform(src, res);
  Book book = (Book) unmar.unmarshal(res.getNode());
  System.out.println(book.title);
}