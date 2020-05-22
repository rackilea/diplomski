public class ATypeAdapter extends TypeAdapter<A> {
  public A read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }
    reader.beginObject();
    String name = reader.nextName();
    if(!"foo".equals(name)) throw new JsonSyntaxException("Expected field named foo");
    A a = new A();
    a.foo = reader.nextString();
    reader.endObject();
    return a;
  }

  public void write(JsonWriter writer, A value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }
    writer.beginObject();
    writer.name("foo");
    writer.value(value.foo);
    writer.endObject();
  }
}