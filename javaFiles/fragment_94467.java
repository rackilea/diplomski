public class NodesAnalyzer extends Analyzer {   
    public TokenStream tokenStream(String fieldName, Reader reader) {

        Tokenizer tokenizer = new StandardTokenizer(reader)
        TokenFilter lowerCaseFilter = new LowerCaseFilter(tokenizer)
        TokenFilter stopFilter = new StopFilter(lowerCaseFilter, Data.stopWords.collect{ it.text } as String[])
        SnowballFilter snowballFilter = new SnowballFilter(stopFilter, new org.tartarus.snowball.ext.ItalianStemmer())

        return snowballFilter
    }   
}

    Analyzer analyzer = new NodesAnalyzer()

    TokenStream ts = analyzer.tokenStream(null, new StringReader(str)); 
    Token token = ts.next()

    while (token != null) {
       String cur = token.term()
       token = ts.next();
    }