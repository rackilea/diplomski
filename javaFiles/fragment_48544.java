SearchRequestBuilder searchRequest = client.prepareSearch("employees")
            .setPostFilter(FilterBuilders.andFilter(
                    FilterBuilders.termFilter("department", "it"),
                    FilterBuilders.existsFilter("passport")
            ));
SearchResponse searchResponse = searchRequest.get();