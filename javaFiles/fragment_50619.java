try (CloseableHttpClient httpClient = HttpClients.createDefault();
     CloseableHttpResponse response = httpClient.execute(request)) {
    int statusCode = response.getStatusLine().getStatusCode();
    final HttpEntity entity = response.getEntity();
    if (entity != null) {
        try (InputStream inputStream = entity.getContent()) {
            // Do something useful with the response
        }
    }
}