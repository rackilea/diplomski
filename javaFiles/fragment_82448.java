public class CustomJacksonObjectMapper extends ObjectMapper {

public CustomJacksonObjectMapper() {
    super();
    DefaultSerializerProvider.Impl sp = new DefaultSerializerProvider.Impl();
    sp.setNullValueSerializer(new NullSerializer());
    this.setSerializerProvider(sp);
  }
}