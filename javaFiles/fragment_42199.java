final Term t = /* ... */;
final ArrayList<Integer> docs = new ArrayList<Integer>();
searcher.search( new TermQuery( t ), new HitCollector() {
    public void collect(int doc, float score) {
        docs.add(doc);
    }
});

for(Integer docid : docs) {
    Document doc = searcher.doc(docid);
    // "FILE" is the field that recorded the original file indexed
    File f = new File( doc.get( "FILE" ) );
    // ...
}