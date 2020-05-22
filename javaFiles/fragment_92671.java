SearchResponse response = client.prepareSearch(clientIndex)
            .setTypes(indexType)
                            .addFields("...", "...")
            .setSearchType(SearchType.DEFAULT)
                            .execute()
                            .actionGet();