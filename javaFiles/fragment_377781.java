@Override
protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new LowerCaseTokenizer(version, reader);
    TokenStream filter = new StopFilter(version, filter, StandardAnalyzer.STOP_WORDS_SET);
    return new TokenStreamComponents(source, filter);
}