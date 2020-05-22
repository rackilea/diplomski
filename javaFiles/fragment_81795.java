public class EnumAdapterFactory implements TypeAdapterFactory {
  private final ResourceBundle bundle;
  private final EnumGenerator generator;

  public EnumAdapterFactory(ResourceBundle bundle, EnumGenerator generator) {
    this.bundle = bundle;
    this.generator = generator;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (!Enum.class.isAssignableFrom(type.getRawType())) return null;

    return (TypeAdapter<T>) new GenericEnumTypeAdapter();
  }

  private final class GenericEnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    public T read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      return generator.create(in.nextString());
    }

    public void write(JsonWriter out, T value) throws IOException {
      if(value == null) {
        out.nullValue();
        return;
      }
      out.value(bundle.getString("enum." 
            + value.getClass().getSimpleName() + "."
            + value.name()));
    }
  }
}