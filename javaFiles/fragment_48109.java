public NestedQueryBuilder nestedBoolQuery(final Map<String, String> propertyValues, final String nestedPath) {

    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    Iterator<String> iterator = propertyValues.keySet().iterator();

    while (iterator.hasNext()) {
        String propertyName = iterator.next();
        String propertValue = propertyValues.get(propertyName);
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(propertyName, propertValue);
        boolQueryBuilder.must(matchQuery);
    }

    return QueryBuilders.nestedQuery(nestedPath, boolQueryBuilder);
}