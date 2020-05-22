try { 
    // if new IndexSearcher throws, searcher will not be initialized, and doesn't need a close. The catch below takes care of reporting the error.
    final IndexSearcher searcher = new IndexSearcher(index.getDirectory(),true);
    try {
        searcher.search(query, new HitCollector() {
                public void collect(int doc, float score) {
                    try {
                        resultWorker.add(new ProcessDocument(searcher.doc(doc)));
                    } catch (CorruptIndexException e) {
                        log.error("Corrupt index found during search", e);
                    } catch (IOException e) {
                        log.error("Error during search", e);
                    }
                }
            });
    } finally {
        searcher.close();
    }
} catch (CorruptIndexException e) {
    log.error("Corrupt index found during search", e);
} catch (IOException e) {
    log.error("Error during search", e);
} finally {
}