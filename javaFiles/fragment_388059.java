IndexSearcher searcher = new IndexSearcher(directory);
QueryParser parser = new QueryParser(Version.LUCENE_30, "content", analyzer);
Query query = parser.parse("terms to search");
TopScoreDocCollector collector = TopScoreDocCollector.create(HOW_MANY_RESULTS_TO_COLLECT, true);
searcher.search(query, collector);

ScoreDoc[] hits = collector.topDocs().scoreDocs;
// `i` is just a number of document in Lucene. Note, that this number may change after document deletion 
for (int i = 0; i < hits.length; i++) {
    Document hitDoc = searcher.doc(hits[i].doc);  // getting actual document
    System.out.println("Title: " + hitDoc.get("title"));
    System.out.println("Content: " + hitDoc.get("content"));
    System.out.println();
}