new CustomScoreQuery(bigramQuery, new FieldScoreQuery("bigram-count", Type.BYTE)) {
  protected CustomScoreProvider getCustomScoreProvider(IndexReader ir) {
    return new CustomScoreProvider(ir) {
      public double customScore(int docnum, float bigramFreq, float docBigramCount) {
         ... calculate Dice's coefficient using bigramFreq and docBigramCount...
         if (diceCoeff >= threshold) {
           String[] stems = ir.document(docnum).getValues("stems");
           ... calculate document similarity score using stems ...
         }
      }
    };
  }
}