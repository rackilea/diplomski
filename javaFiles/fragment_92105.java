new CustomScoreQuery(bigramQuery) {
  protected CustomScoreProvider getCustomScoreProvider(ReaderContext rc) {
    final AtomicReader ir = ((AtomicReaderContext)rc).reader();
    final ValueSource 
       bgCountSrc = ir.docValues("bigram-count").getSource(),
       stemSrc = ir.docValues("stems").getSource();
    return new CustomScoreProvider(rc) {
      public float customScore(int docnum, float bgFreq, float... fScores) {
        final long bgCount = bgCountSrc.getInt(docnum);
        ... calculate Dice's coefficient using bgFreq and bgCount ...
        if (diceCoeff >= threshold) {
          final String stems = 
             stemSrc.getBytes(docnum, new BytesRef())).utf8ToString();
          ... calculate document similarity score using stems ...
        }
      }
    };
  }
}