Search search = new Search.Builder(query)
            .addIndex(aptitudeIndexName)
            .addType(aptitudeTypeName)
            .build();

    try {
        SearchResult result = client.execute(search);


        MaxAggregation max1 = result.getAggregations().getMaxAggregation("max1");
        Double max = max1.getMax();
        return max.longValue() + 1;//so it would add 1 to the current maximum id