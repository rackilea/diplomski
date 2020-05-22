ObjectMapper mapper = new ObjectMapper();
    Observable<String> response = accountSearchService.searchAccount(paramMap, "", 0, 1);
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    response.subscribe(stringValue -> {
            AccountSearchResult resultDto = mapper.convertValue(stringValue, AccountSearchResult.class);
        }, throwable -> {
            //onError
        });