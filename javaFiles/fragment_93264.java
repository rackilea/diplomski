private int index(File indexDir, File dataDir, String suffix) throws Exception {
    RAMDirectory ramDir = new RAMDirectory();          // 1
    IndexWriter indexWriter = new IndexWriter(
            ramDir,                                    // 2
            new SimpleAnalyzer(),
            true,
            IndexWriter.MaxFieldLength.LIMITED);
    indexWriter.setUseCompoundFile(false);
    indexDirectory(indexWriter, dataDir, suffix);
    int numIndexed = indexWriter.maxDoc();
    indexWriter.optimize();
    indexWriter.close();

    Directory.copy(ramDir, FSDirectory.open(indexDir), false); // 3

    return numIndexed;
}