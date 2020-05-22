private static JSONObject sendRequest(JSONObject json) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder(new URI(BASE_URL))
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .timeout(TIMEOUT_DURATION)
            .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
            .build();

    HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    String jsonResponse = httpResponse.body();

    return new JSONObject(jsonResponse);
}