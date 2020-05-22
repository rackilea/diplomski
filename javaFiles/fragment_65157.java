public final class MyAnalyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
        TokenStream tok = new StandardFilter(matchVersion, src);
        tok = new LowerCaseFilter(matchVersion, tok);
        tok = new StopFilter(matchVersion, tok, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        return new TokenStreamComponents(src, tok);
    }

    @Override
    protected Reader initReader(String fieldName, Reader reader) {
        //return your CharFilter-wrapped reader here
    }
}