void createIndex(RestHighLevelClient client) throws IOException, URISyntaxException {
            if (!isIndexExist(client, indexName)) {
                String indexString = getStringFromFile("your file name");
                CreateIndexRequest request = new CreateIndexRequest(indexName);
                request.source(indexString, XContentType.JSON);
                client.indices().create(request, RequestOptions.DEFAULT);
            }
    }