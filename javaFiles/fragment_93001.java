QueryBuilder rangeQuery = QueryBuilders
                .rangeQuery("field")
                .from("2016-01-01||/D")
                .to("2017-01-01||/D")
                .includeLower(true)
                .includeUpper(false);



                QueryBuilder termsQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery("field1","12"))
                .must(QueryBuilders.termQuery("field2", "abc"))
                .must(QueryBuilders.termQuery("field3", "def"));


                QueryBuilder qb = QueryBuilders
                .boolQuery()
                .should(rangeQuery)
                .should(termsQuery);