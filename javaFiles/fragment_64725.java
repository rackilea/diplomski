@Configuration
public class ObjectMapperConfig {

  @Bean
  public ObjectMapper objectMapper() {
    var mapper = new ObjectMapper();

    var module = new SimpleModule();
    module.addSerializer(Decimal128.class, new Decimal128Serializer());
    mapper.registerModule(module);

    return mapper;
  }

  private static class Decimal128Serializer extends JsonSerializer<Decimal128> {
    @Override
    public void serialize(Decimal128 v, JsonGenerator g, SerializerProvider p) throws IOException {
      g.writeNumber(v.bigDecimalValue());
    }
  }
}