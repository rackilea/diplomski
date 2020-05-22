BoolQueryBuilder queryBuiler = new BoolQueryBuilder();
        queryBuiler.must(new QueryStringQueryBuilder("tagName : *salary march*").defaultOperator(Operator.AND));

SearchResponse response = esclient.prepareSearch(index).setTypes(type)
                .setQuery(queryBuiler)
                .execute().actionGet();

SearchHit[] hits = response.getHits().getHits();
                for (SearchHit hit : hits) {
                Map map = hit.getSource();
                System.out.println((String) map.get("tagName"));
                list.add((String) map.get("tagName"));
            }

            list = list.stream().distinct().collect(Collectors.toList());

            for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i)); 
            }
    }