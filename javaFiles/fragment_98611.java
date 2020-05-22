public Indexer(Directory indexDir, PrintStream printStream) throws IOException {
    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_43, new Analyzer());
    writerConfig.setIndexDeletionPolicy(new SnapshotDeletionPolicy(new KeepOnlyLastCommitDeletionPolicy()));
    indexWriter = new IndexWriter(indexDir, writerConfig);
    snapshotter = (SnapshotDeletionPolicy) indexWriter.getConfig().getIndexDeletionPolicy();
}