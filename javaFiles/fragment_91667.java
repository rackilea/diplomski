BoolQueryBuilder query = new BoolQueryBuilder();
        query.must(new QueryStringQueryBuilder("tagName:*June*"));
        query.must(new TermQueryBuilder("employeeid", 358));

        SearchResponse response12 = esclient.prepareSearch(index).setTypes("emptagnames")
                .setQuery(query)
                .execute().actionGet();

        SearchHit[] hits2 = response12.getHits().getHits();
        System.out.println(hits2.length);

        for (SearchHit hit : hits2) {
            Map map = hit.getSource();
            System.out.println((String) map.get("tagName"));
        }