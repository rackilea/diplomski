@RequestMapping(method = RequestMethod.GET, value = "/path")
public ResponseEntity<Resources<Resource<Data>>> getAllData() {
    return getAllDataImpl()
}

@HystrixCommand(fallbackMethod = "myFallbackMethod")
public ResponseEntity<Resources<Resource<Data>>> getAllDataImpl() {
    String url = "http://localhost:8080/someotherpath"

    ParameterizedTypeReference<Iterable<Data>> responseType = new ParameterizedTypeReference<Iterable<Data>>() {};
    ResponseEntity<Iterable<Data>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

    if (response.getStatusCode().is2xxSuccessful()) {
        Iterable<Data> data = response.getBody();
        Resources<Resource<Data>> resources = assembler.toResource(data);
        return new ResponseEntity<>(resources, response.getHeaders(), response.getStatusCode());
    }
    return new ResponseEntity<>(response.getHeaders(), response.getStatusCode());
}