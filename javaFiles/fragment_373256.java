SearchResponse suggestRequestBuilder = elasticClient.prepareSearch(index)
        .suggest(new SuggestBuilder()
                     .addSuggestion(
                        "suggestionsFuzzy",
                        SuggestBuilders.completionSuggestion("myField")
                            .prefix(suggestRequest, Fuzziness.AUTO).size(10)
                     )
        ).get();