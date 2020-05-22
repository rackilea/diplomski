public static void main(String[] args) throws IOException, ParseException {
    StandardAnalyzer standardAnalyzer = new StandardAnalyzer(Version.LUCENE_46);
    RAMDirectory ramDirectory = new RAMDirectory();

    IndexWriter indexWriter = new IndexWriter(ramDirectory, new IndexWriterConfig(Version.LUCENE_46, standardAnalyzer));

    Document d0 = new Document();
    d0.add(new TextField("employeeId", "foo", Field.Store.YES));
    d0.add(new IntField("documentoId", 1, Field.Store.YES));
    indexWriter.addDocument(d0);

    Document d1 = new Document();
    d1.add(new TextField("employeeId", "bar", Field.Store.YES));
    d1.add(new IntField("documentoId", 20, Field.Store.YES));
    indexWriter.addDocument(d1);

    Document d2 = new Document();
    d2.add(new TextField("employeeId", "baz", Field.Store.YES));
    d2.add(new IntField("documentoId", 3, Field.Store.YES));
    indexWriter.addDocument(d2);

    indexWriter.commit();

    GroupingSearch groupingSearch = new GroupingSearch("documentoId");
    Sort groupSort = new Sort(new SortField("documentoId", SortField.Type.INT, true));  // in descending order
    groupingSearch.setGroupSort(groupSort);
    groupingSearch.setSortWithinGroup(groupSort);

    IndexReader reader = DirectoryReader.open(ramDirectory);
    IndexSearcher searcher = new IndexSearcher(reader);

    TopGroups<?> groups = groupingSearch.search(searcher, new MatchAllDocsQuery(), 0, 10);

    Document highestScoredDocument = reader.document(groups.groups[0].scoreDocs[0].doc);
    System.out.println(
            "Descending order, first document is " +
                    "employeeId:" + highestScoredDocument.get("employeeId") + " " +
                    "documentoId:" + highestScoredDocument.get("documentoId")
    );
}