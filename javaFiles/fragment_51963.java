public void printDocument(org.apache.lucene.document.Document doc) {
    List<IndexableField> fields = doc.getFields();
    for (int i = 0; i < fields.size(); i++) {
        System.out.println(fields.get(i).stringValue());
    }

}