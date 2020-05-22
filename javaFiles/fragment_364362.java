Response response = client
    .target("https://serverUrl")
    .path("/v1/search")
    .queryParam("q", "someQuery")
    .request("application/json")
    .header("Content-Type", "application/json")
    .header("authorization", "a7b857f6-........rest of my token")
    .get();