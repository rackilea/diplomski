final MAX_RESULTS = 10000;
final Term t = /* ... */;
final TopDocs topDocs = searcher.search( new TermQuery( t ), MAX_RESULTS );
for ( ScoreDoc scoreDoc : topDocs.scoreDocs ) {
    Document doc = searcher.doc( scoreDoc.doc )
    // "FILE" is the field that recorded the original file indexed
    File f = new File( doc.get( "FILE" ) );
    // ...
}