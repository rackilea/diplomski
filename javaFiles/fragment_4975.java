public static void main(String[] args) throws Exception {
    // Create the in memory lucence index
    RAMDirectory ramDir = new RAMDirectory();

    // Create the analyzer (has default stop words)
    Analyzer analyzer = new StandardAnalyzer();

    // Create a set of documents to work with
    createDocs(ramDir, analyzer);

    // Query the set of documents
    queryDocs(ramDir, analyzer);
}

private static void createDocs(RAMDirectory ramDir, Analyzer analyzer) 
        throws IOException {
    // Setup the configuration for the index
    IndexWriterConfig config = new IndexWriterConfig(analyzer);
    config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

    // IndexWriter creates and maintains the index
    IndexWriter writer = new IndexWriter(ramDir, config);

    // Create the documents
    indexDoc(writer, "document-1", "hello planet mercury");
    indexDoc(writer, "document-2", "hi PLANET venus");
    indexDoc(writer, "document-3", "howdy Planet Earth");
    indexDoc(writer, "document-4", "hey planet MARS");
    indexDoc(writer, "document-5", "ayee Planet jupiter");

    // Close down the writer
    writer.close();
}

private static void indexDoc(IndexWriter writer, String name, String content) 
        throws IOException {
    Document document = new Document();
    document.add(new TextField("name", name, Field.Store.YES));
    document.add(new TextField("body", content, Field.Store.YES));

    writer.addDocument(document);
}

private static void queryDocs(RAMDirectory ramDir, Analyzer analyzer) 
        throws IOException, ParseException {
    // IndexReader maintains access to the index
    IndexReader reader = DirectoryReader.open(ramDir);

    // IndexSearcher handles searching of an IndexReader
    IndexSearcher searcher = new IndexSearcher(reader);

    // Setup a query
    QueryParser parser = new QueryParser("body", analyzer);
    Query query = parser.parse("hey earth");

    // Search the index
    TopDocs foundDocs = searcher.search(query, 10);
    System.out.println("Total Hits: " + foundDocs.totalHits);

    for (ScoreDoc scoreDoc : foundDocs.scoreDocs) {
        // Get the doc from the index by id
        Document document = searcher.doc(scoreDoc.doc);
        System.out.println("Name: " + document.get("name") 
                + " - Body: " + document.get("body") 
                + " - Score: " + scoreDoc.score);
    }

    // Close down the reader
    reader.close();
}