CustomAnalyzer customAnalyzer = new CustomAnalyzer();    
        Directory directory = FSDirectory.open(Paths.get("directoryPath"));
        IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig(customAnalyzer));
        Document doc1 = new Document();
        doc1.add(new TextField("text", "WAS_sample_tc", Field.Store.YES));
        writer.addDocument(doc1);
        writer.close();

        QueryBuilder queryBuilder = new QueryBuilder(customAnalyzer);
        Query query = queryBuilder.createPhraseQuery("text", "sample", 15);

        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));

        TopDocs topDocs = searcher.search(query, 10);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println(doc.toString());
        }