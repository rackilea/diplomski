SearchRequestBuilder srb = client
.prepareSearch("preference_index", "address_index", "interests_index", "details_index")
.setTypes("preference_doc", "address_doc", "interests_doc", "details_doc")
.setSearchType(SearchType.DEFAULT);

QueryBuilder boolBuilder = QueryBuilders.boolQuery().should(
QueryBuilders.matchQuery("id_customer", "14"));

SearchResponse response = srb.setSize(4).execute().actionGet();
SearchHit[] docs = response.getHits().getHits();