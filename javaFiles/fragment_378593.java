@Autowire
private ObjectMapper objectMapper;

public Mono<ServerResponse> fooBar() throws IOException {
    return Mono.fromCallable(() -> objectMapper.readValue(new ClassPathResource("data/Foo.json")
            .getURL(), Foo.class))
            .subscribeOn(Schedulers.boundedElastic())
            .flatMap(foo -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .syncBody(foo));

}