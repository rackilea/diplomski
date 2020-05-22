class MapperFactory {

  private final ObjectMapper jsonMapper = configure(new ObjectMapper());
  private final XmlMapper xmlMapper = configure(new XmlMapper());
  private final CsvMapper csvMapper = configure(new CsvMapper());

  public ObjectMapper getJsonMapper() {
    return jsonMapper;
  }

  public XmlMapper getXmlMapper() {
    return xmlMapper;
  }

  public CsvMapper getCsvMapper() {
    return csvMapper;
  }

  public <T extends ObjectMapper> T configure(T mapper) {
    // configure mapper instance if required
    mapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
    // register default
    mapper.findAndRegisterModules();
    // register custom
    mapper.registerModule(createCustomModule());

    return mapper;
  }

  public SimpleModule createCustomModule() {
    SimpleModule module = new SimpleModule("EntityMixIns");
    module.setMixInAnnotation(Entity.class, EntityMixIn.class);
    // more MixIns

    return module;
  }
}