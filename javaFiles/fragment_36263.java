String auth = "username:password";
    String base64Creds = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .header("Authorization", "Basic " + base64Creds)
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build();