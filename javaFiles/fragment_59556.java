public final class CustomKeywordAnalyzer extends Analyzer {
  public CustomKeywordAnalyzer() {
  }

  @Override
  protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
    Tokenizer tokenizer = new KeywordTokenizer(reader)
    TokenStream filter = new TrimFilter(Version.LUCENE_43, tokenizer);
    return new TokenStreamComponents(tokenizer, filter);
  }
}