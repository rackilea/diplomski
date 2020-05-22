public interface MyRestTemplateAdapter {
    Object genericPost(String url);

    // same signature from RestTemplate that you want to reuse
    <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables);
}