Analyzer analyzer = new Analyzer() {
 @Override
  protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new LetterTokenizer(Version.LUCENE_44, reader);
    TokenStream filter = new LowercaseFilter(Version.LUCENE_44, source);
    return new TokenStreamComponents(source, filter);
  }
};