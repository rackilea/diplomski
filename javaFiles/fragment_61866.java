public static BasicStats getBasicStats(IndexReader indexReader, Term myTerm, float queryBoost) throws IOException {
    String fieldName = myTerm.field();

    CollectionStatistics collectionStats = new CollectionStatistics(
            "field",
            indexReader.maxDoc(),
            indexReader.getDocCount(fieldName),
            indexReader.getSumTotalTermFreq(fieldName),
            indexReader.getSumDocFreq(fieldName)
            );

    TermStatistics termStats = new TermStatistics(
            myTerm.bytes(),
            indexReader.docFreq(myTerm),
            indexReader.totalTermFreq(myTerm)
            );

    BasicStats myStats = new BasicStats(fieldName, queryBoost);
    assert collectionStats.sumTotalTermFreq() == -1 || collectionStats.sumTotalTermFreq() >= termStats.totalTermFreq();
    long numberOfDocuments = collectionStats.maxDoc();

    long docFreq = termStats.docFreq();
    long totalTermFreq = termStats.totalTermFreq();

    if (totalTermFreq == -1) {
      totalTermFreq = docFreq;
    }

    final long numberOfFieldTokens;
    final float avgFieldLength;

    long sumTotalTermFreq = collectionStats.sumTotalTermFreq();

    if (sumTotalTermFreq <= 0) {
        numberOfFieldTokens = docFreq;
        avgFieldLength = 1;
    } else {
        numberOfFieldTokens = sumTotalTermFreq;
        avgFieldLength = (float)numberOfFieldTokens / numberOfDocuments;
    }

    myStats.setNumberOfDocuments(numberOfDocuments);
    myStats.setNumberOfFieldTokens(numberOfFieldTokens);
    myStats.setAvgFieldLength(avgFieldLength);
    myStats.setDocFreq(docFreq);
    myStats.setTotalTermFreq(totalTermFreq);

    return myStats;
}