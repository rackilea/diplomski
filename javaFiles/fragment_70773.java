private static Version VERSION;

public static void main(String[] args) throws IOException, ParseException {
    //prepare
    VERSION = Version.LUCENE_4_9;
    Directory dir = new RAMDirectory();
    IndexWriterConfig config = new IndexWriterConfig(VERSION, new SimpleAnalyzer(VERSION));
    IndexWriter writer = new IndexWriter(dir, config);

    String countryCode = "DE";

    //index
    Document doc = new Document();
    doc.add(new TextField("countryCode", countryCode, Field.Store.YES));
    writer.addDocument(doc);
    writer.close();

    IndexSearcher search = new IndexSearcher(DirectoryReader.open(dir));
    //lookup
    Query query = new QueryParser(VERSION, "countryCode", new SimpleAnalyzer(VERSION)).parse(countryCode);

    TopDocs docs = search.search(query, 1);
    System.out.println(docs.totalHits);
}