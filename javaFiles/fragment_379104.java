ValidateQueryRequest validateQueryRequest = new ValidateQueryRequest(indexName);
validateQueryRequest.source(jsonContent);
validateQueryRequest.explain(true);

ActionFuture<ValidateQueryResponse> future = client.admin().indices().validateQuery(validateQueryRequest); // the client is org.elasticsearch.client.Client
ValidateQueryResponse response = future.get(); // typical java future as response
System.out.println(response.isValid()); // true or false
System.out.println(response.getQueryExplanation().size()); // size of explanations why the query is incorrect