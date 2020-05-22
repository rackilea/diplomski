client.prepareSearch("myindex").
                setTypes("mytype").
                setQuery(
                        QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),
                                FilterBuilders.andFilter(FilterBuilders.termFilter("server", "x"), FilterBuilders.rangeFilter("dt_time").to("to").from("from")))).
                addAggregation(AggregationBuilders.avg("cpu_agg")
                        .field("cpu_time"))
                .get();