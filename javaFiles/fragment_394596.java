long BUFFER_SIZE = 120 * 1024 * 1024;     <---- set buffer to 120MB instead of 100MB
Map<String, String> params = Collections.emptyMap();
HttpEntity entity = new NStringEntity(contentSearchSourceBuilder.toString(), ContentType.APPLICATION_JSON);
HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory consumerFactory =
        new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(BUFFER_SIZE);
Response response = restClient.performRequest("GET", "/document_attachment/doc/_search", params, entity, consumerFactory);