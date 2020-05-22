public static void suggestSearch() 
    {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost( "your-ip-here", 9200, "http" ) ) );

        SearchRequest searchRequest = new SearchRequest( "music" );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        SuggestionBuilder termSuggestionBuilder = SuggestBuilders.completionSuggestion( "suggest" ).prefix( "nev" );
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion( "song-suggest", termSuggestionBuilder );
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
        CompletionSuggestion entries = suggest.getSuggestion( "song-suggest" );

        for ( CompletionSuggestion.Entry entry : entries )
        {
            for ( CompletionSuggestion.Entry.Option option : entry.getOptions() )
            {
                String suggestText = option.getText().string();
                System.out.println( suggestText );
            }
        }
    }