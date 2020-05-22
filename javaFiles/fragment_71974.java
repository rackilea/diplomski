BoolQueryBuilder startDateQuery = new BoolQueryBuilder()
   .should(QueryBuilders.missingQuery("startDate"))
   .should(QueryBuilders.rangeQuery("startDate").lte("now"))
   .minimumShouldMatch(1);
BoolQueryBuilder endDateQuery = new BoolQueryBuilder()
   .should(QueryBuilders.missingQuery("endDate"))
   .should(QueryBuilders.rangeQuery("endDate").gte("now"))
   .minimumShouldMatch(1);
BoolQueryBuilder queryBuilder = new BoolQueryBuilder()
   .filter(startDateQuery)
   .filter(endDateQuery);