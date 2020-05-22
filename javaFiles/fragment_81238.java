BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
boolQuery.should(QueryBuilders.termsQuery("lang", "en"));
boolQuery.should(QueryBuilders.termsQuery("location", "en"));

BoolQueryBuilder titleBoolQuery = QueryBuilders.boolQuery();
titleBoolQuery.should(QueryBuilders.termsQuery("title", new String[]{"americanlegion", "conversion"}));
titleBoolQuery.must(QueryBuilders.termQuery("title", "conversion"));

boolQuery.should(titleBoolQuery);