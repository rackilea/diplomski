public class ProductAdapter extends TypeAdapter<Product> {

  public Product read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    String json = reader.nextString();

    // convert String to product ... assuming Product has a 
    // constructor that creates an instance from a String
    return new Product(json);
  }

  public void write(JsonWriter writer, Product value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }

    // convert Product to String .... assuming Product has a method getAsString()
    String json = value.getAsString();
    writer.value(json);
  }
}