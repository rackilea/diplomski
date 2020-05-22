client.prepareSearch("index").setTypes("types").addAggregation(
                AggregationBuilders.terms("agg_name").field("gender").subAggregation(
                        AggregationBuilders.topHits("documents").setSize(10)
                )
        ).execute(new ActionListener<SearchResponse>() {
            @Override
            public void onResponse(SearchResponse response) {
                Terms agg_name_aggregation=response.getAggregations().get("agg_name");
                for (Terms.Bucket bucket : agg_name_aggregation.getBuckets()) {
                    TopHits topHits=bucket.getAggregations().get("documents");
                    System.out.println("term = " + bucket.getKey());
                    // do what you want with top hits..
                }
            }

            @Override
            public void onFailure(Throwable e) {
                e.printStackTrace();
            }
        });