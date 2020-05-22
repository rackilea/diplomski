private static class CustomAnalyzer extends Analyzer{
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        final int flags = GENERATE_WORD_PARTS|CATENATE_WORDS|CATENATE_NUMBERS|CATENATE_ALL|PRESERVE_ORIGINAL;
        Tokenizer tokenizer = new StandardTokenizer();
        return new TokenStreamComponents(tokenizer,new WordDelimiterGraphFilter(tokenizer, flags, null ));
    }
}