final InputStream fis = new FileInputStream(new File("c:\\autoexec.bat")); // or whatever
final RequestCallback requestCallback = new RequestCallback() {
     @Override
    public void doWithRequest(final ClientHttpRequest request) throws IOException {
        request.getHeaders().add("Content-type", "application/octet-stream");
        IOUtils.copy(fis, request.getBody());
     }
};
final RestTemplate restTemplate = new RestTemplate();
SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
requestFactory.setBufferRequestBody(false);     
restTemplate.setRequestFactory(requestFactory);     
final HttpMessageConverterExtractor<String> responseExtractor =
    new HttpMessageConverterExtractor<String>(String.class, restTemplate.getMessageConverters());
restTemplate.execute("http://localhost:4000", HttpMethod.POST, requestCallback, responseExtractor);