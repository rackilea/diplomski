public SomethingProductDataProvider(DocumentSource source, String tocDocumentName,
                                    boolean checkTocModifications) {
  this.source = source;
  this.tocDocumentName = tocDocumentName;
  this.checkTocModifications = checkTocModifications;
  this.toc = loadToc();
}

private ReadonlyTableOfContents loadToc() {
  Document doc = source.getDocument(tocDocumentName);
  if (doc == null) {
    throw new IllegalArgumentException("Can' find table of contents file " + 
        tocResourcePath);
  }

  try {
    Element tocElement = doc.getDocumentElement();
    ReadonlyTableOfContents toc = new ReadonlyTableOfContents();
    toc.initFromXml(tocElement);
    return toc;
  } catch (Exception e) {
    throw new RuntimeException("Error creating toc from xml.", e);
  }
}