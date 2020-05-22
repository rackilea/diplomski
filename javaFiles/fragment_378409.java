protected Document getDocument(File f) throws Exception {
    Document doc = new Document();
    String docLength = Integer.toString(io.getDocLength(f));
    doc.add(new Field("contents", new FileReader(f), Field.TermVector.YES));
    doc.add(new Field("docLength", i, Field.Store.YES, Field.Index.NOT_ANALYZED));
    doc.add(new Field("filename", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    doc.add(new Field("fullpath", f.getCanonicalPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));         
    return doc;
}