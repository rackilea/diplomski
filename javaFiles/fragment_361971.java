public class CustomAnalysisDefinitionProvider implements LuceneAnalysisDefinitionProvider {
    @Override
    public void register(LuceneAnalyzerDefinitionRegistryBuilder builder) {
        builder.analyzer( "myAnalyzer" )
                        .tokenizer( KeywordTokenizerFactory.class )
                        .tokenFilter( ClassicFilterFactory.class )
                        .tokenFilter( LowerCaseFilterFactory.class )
                        .tokenFilter( StopFilterFactory.class )
                                // You can pass parameters like this
                                .param( "mapping", "org/hibernate/search/test/analyzer/stoplist.properties" )
                                .param( "ignoreCase", "true" );

        // You can define multiple analyzers
        builder.analyzer( "otherAnalyzer" )
                        .tokenizer( ... ) ...
    }
}