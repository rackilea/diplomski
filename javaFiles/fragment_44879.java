// CategoryChildSerializer.java
public class CategoryChildSerializer extends JsonSerializer<Category> implements ResolvableSerializer {
  private JsonSerializer<Object> defaultSerializer;
  private JsonSerializer<Object> idSerializer;

  public void serialize(Category value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
    if(provider.getActiveView() == Category.TreeView.class)
      defaultSerializer.serialize(value, gen, provider);
    else
      idSerializer.serialize(value.getId(), gen, provider);
  }

  public void resolve(SerializerProvider provider) throws JsonMappingException {
    defaultSerializer = provider.findValueSerializer(Category.class);
    idSerializer = provider.findValueSerializer(Integer.class);
  }
}