String aggregations1 = "CLASSIFICATION";
        String field1 = "ALARM DATE";
        DateHistogramInterval interval1 = DateHistogramInterval.DAY;

        SearchResponse sr = client.prepareSearch(index).setTypes(type)
                .addAggregation(AggregationBuilders.dateHistogram("classification of day").field(field1)
                        .interval(interval1).format("dd/MM/yyyy")
                        .subAggregation(AggregationBuilders.terms("classifications").field(aggregations1)))
                .execute().actionGet();





        // sr is here your SearchResponse object
        Histogram agg = sr.getAggregations().get("classification of day");

        Collection<Histogram.Bucket> buckets = (Collection<Histogram.Bucket>) agg.getBuckets();
        // For each entry

        for (Histogram.Bucket bucket : buckets) {

            if (bucket.getDocCount() != 0) {

                System.out.println((int) bucket.getDocCount());
                System.out.println(bucket.getKeyAsString());
                Terms terms =bucket.getAggregations().get("classifications");
                Collection<Terms.Bucket> bkts = terms.getBuckets();
                for (Bucket b : bkts) {

                    if (b.getDocCount() != 0) {
                        //ESClassification classificaiton = new ESClassification();
                        System.out.println((int) b.getDocCount());
                        System.out.println(b.getKeyAsString());

                    } else {
                        //list = Collections.<ESClassification> emptyList();
                    }

                }


            } else {
                //list = Collections.<ESClassification> emptyList();
            }

        }