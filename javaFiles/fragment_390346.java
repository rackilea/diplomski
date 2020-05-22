RestClient client = ...;
String actionMetaData = String.format("{ \"index\" : { \"_index\" : \"%s\", \"_type\" : \"%s\" } }%n", index, type);

List<String> bulkData = ...; // a list of your documents in JSON strings    
StringBuilder bulkRequestBody = new StringBuilder();
for (String bulkItem : bulkData) {
    bulkRequestBody.append(actionMetaData);
    bulkRequestBody.append(bulkItem);
    bulkRequestBody.append("\n");
}
HttpEntity entity = new NStringEntity(bulkRequestBody.toString(), ContentType.APPLICATION_JSON);
try {
    Response response = client.performRequest("POST", "/your_index/your_type/_bulk", Collections.emptyMap(), entity);
    return response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
} catch (Exception e) {
    // do something
}