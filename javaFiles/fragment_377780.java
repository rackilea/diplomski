private final Pattern nonAlpha = Pattern.compile(".*[^a-z].*");
@Override
protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new StandardTokenizer(version, reader);
    TokenStream filter = new StandardFilter(version, source);
    filter = new LowerCaseFilter(version, filter);
    filter = new StopFilter(version, filter, StandardAnalyzer.STOP_WORDS_SET);
    filter = new PatternReplaceCharFilter(nonAlpha, "", filter);
    return new TokenStreamComponents(source, filter);
}