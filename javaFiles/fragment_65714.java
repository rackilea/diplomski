private static class ResponseFromHeadersExtractor implements ResponseExtractor<ClientHttpResponse> {

    @Override
    public ClientHttpResponse extractData(ClientHttpResponse response) {
        System.out.println("StringFromHeadersExtractor - response headers: " + response.getHeaders());
        return response;
    }
}