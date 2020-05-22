private static SearchAnalyticsQueryRequest createSearchAnalyticsQueryRequest() {
        SearchAnalyticsQueryRequest searQueryRequest = new SearchAnalyticsQueryRequest();
        searQueryRequest.setStartDate("2016-04-10");
        searQueryRequest.setEndDate("2016-04-20");
        List<String> dimensions = new ArrayList<String>();
        dimensions.add("page");
        dimensions.add("query");
        dimensions.add("country");
        dimensions.add("device");
        dimensions.add("date");
        searQueryRequest.setDimensions(dimensions);
        return searQueryRequest;
    }