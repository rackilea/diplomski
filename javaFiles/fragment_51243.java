public static void suggestSearch()
    {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost( "192.168.1.245", 9200, "http" ) ) );

        SearchRequest searchRequest = new SearchRequest( "hotels" );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
       searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        CompletionSuggestionBuilder completionSuggestionBuilder = SuggestBuilders.completionSuggestion( "name_suggest" ).prefix( "M" );

        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion( "name_suggest", completionSuggestionBuilder );
        searchSourceBuilder.suggest( suggestBuilder );

        searchRequest.source( searchSourceBuilder );
        SearchResponse searchResponse = null;

        try
        {
            searchResponse = client.search( searchRequest );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }

        Suggest suggest = searchResponse.getSuggest();
        CompletionSuggestion entries = suggest.getSuggestion( "name_suggest" );

        for ( CompletionSuggestion.Entry entry : entries )
        {
            for ( CompletionSuggestion.Entry.Option option : entry.getOptions() )
            {
                String suggestText = option.getText().string();
                System.out.println( suggestText );
            }
        }
    }