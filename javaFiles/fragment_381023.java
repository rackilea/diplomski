public static String Query(String site,
            SearchAnalyticsQueryRequest searQueryRequest) throws Exception {

        Webmasters.Searchanalytics.Query query = service.searchanalytics()
                .query(site, searQueryRequest);
        SearchAnalyticsQueryResponse queryResponse = query.execute();

        return queryResponse.toPrettyString();
    }