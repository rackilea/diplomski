public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
    HttpEntityRequestCallback requestCallback = new HttpEntityRequestCallback(request, responseType);
    HttpMessageConverterExtractor<T> responseExtractor =
            new HttpMessageConverterExtractor<T>(responseType, getMessageConverters());
    return execute(url, HttpMethod.POST, requestCallback, responseExtractor);
}