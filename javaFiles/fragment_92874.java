@Bean(name = "jsonView")
public MappingJacksonJsonView jsonView() {
    final MappingJacksonJsonView mappingJacksonJsonView = new MappingJacksonJsonView();
    mappingJacksonJsonView.setContentType("application/json");
    mappingJacksonJsonView.setObjectMapper(new CustomObjectMapper());
    return mappingJacksonJsonView;
}