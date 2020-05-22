private void updateIndex2DataForId(String id) throws ParseException, IOException {
    // Get all terms containing the node id
    TermDocs termDocs = index1Reader.termDocs(new Term("id", id));
    // Iterate
    Document doc = new Document();
    doc.add(new Field("id", id, Store.YES, Index.NOT_ANALYZED));
    int docId = -1;
    StringBuffer buffer = new StringBuffer();
    while (termDocs.next()) {
        docId = termDocs.doc();
        buffer .append(keys[docId] + " "); // keys[] is pre-populated using FieldCache                 
    }
    doc.add(new Field("id", buffer.trim().toString(), Store.YES, Index.ANALYZED));   
    index2Writer.addDocument(doc);
}

String[] keys = FieldCache.DEFAULT.getStrings(index1Reader, "keywords");