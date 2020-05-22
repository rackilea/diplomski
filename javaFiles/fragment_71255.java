public String fetchPictureUrl(String userId, ImageType imageType) {
    URI uri = URIBuilder.fromUri(GRAPH_API_URL + userId + "/picture" +
            "?type=" + imageType.toString().toLowerCase() + "&redirect=false").build();

    JsonNode response = getRestTemplate().getForObject(uri, JsonNode.class);
    return response.get("data").get("url").getTextValue();
}