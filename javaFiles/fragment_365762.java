Analyzer analyzer = new Analyzer() {
 @Override
  protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new NGramTokenizer(reader, 12, 12);
    TokenStream filter = new LowercaseFilter(source);
    return new TokenStreamComponents(source, filter);
  }
};