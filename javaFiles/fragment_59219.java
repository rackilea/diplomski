DeleteByQueryRequestBuilder requestBuilder=new DeleteByQueryRequestBuilder(transportClient);
requestBuilder.setQuery(
                QueryBuilders
                        .boolQuery()
                        .must(QueryBuilders.termQuery("myid", "2"))
                        .minimumShouldMatch("100%")
                        .should(QueryBuilders.matchPhraseQuery("hnumber", "22"))
                        .minimumNumberShouldMatch(1)
        );
requestBuilder.get(); //it have the response