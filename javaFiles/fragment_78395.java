public class MyDogSerializer extends StdSerializer<Dog> {

  private static final long serialVersionUID = -4796382940375974812L;

  public MyDogSerializer() {
    super(Dog.class);
  }

  @Override
  public void serialize(Dog value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException, JsonProcessingException {
    if (/** here inspect Dog value for emptiness */) {
      gen.writeObject(null);
    } else {
      ****
    }
  }
}