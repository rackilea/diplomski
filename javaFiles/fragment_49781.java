@Override
protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
    Tokenizer source = new LetterTokenizer(Version.LUCENE_44, reader);              
    TokenStream filter = new LowerCaseFilter(Version.LUCENE_44, source);                
    filter = new StopFilter(Version.LUCENE_44, filter, stopWords);                  
    filter = new PorterStemFilter(filter);
    return new TokenStreamComponents(source, filter);
}