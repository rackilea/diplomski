client.prepareSearch("myindex", "myfeed")
            .setQuery(
                    QueryBuilders.queryString("myterm:myvalue")
                            .analyzer("myanalyzer")
            )
            .execute()
            .actionGet();