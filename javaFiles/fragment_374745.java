restTemplate.setErrorHandler(new ResponseErrorHandler() {
                @Override
                public boolean hasError(ClientHttpResponse response) throws IOException {
                    return response.getStatusCode().is4xxClientError();
                }

                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                    String errorResponse = new String(getResponseBody(response), getCharset(response).name());
                    Log.e(TAG, "handleError: called with: " + errorResponse);
                }
            });

private byte[] getResponseBody(ClientHttpResponse response) {
    try {
        InputStream responseBody = response.getBody();
        if (responseBody != null) {
            return FileCopyUtils.copyToByteArray(responseBody);
        }
    } catch (IOException ex) {
        // ignore
    }
    return new byte[0];
}

private Charset getCharset(ClientHttpResponse response) {
    HttpHeaders headers = response.getHeaders();
    MediaType contentType = headers.getContentType();
    return contentType != null ? contentType.getCharSet() : Charset.defaultCharset();
}