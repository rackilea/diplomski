public String publish(String objectId, String connectionType, MultiValueMap<String, Object> data) {
    MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<String, Object>(data);
    URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId + "/" + connectionType).build();
    Map<String, Object> response = getRestTemplate().postForObject(uri, requestData, Map.class);
    return (String) response.get("id");
}