class MyStemmerAnalyzer extends Analyzer {
    @override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        TokenStream stream = new StandardTokenizer(reader);
        stream = new StandardFilter(stream);
        stream = new LowerCaseFilter(stream);
        stream = new PorterStemFilter(stream);
        stream = new StopFilter(stream, StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        return stream;
    }
}