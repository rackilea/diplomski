public class ListTypeAdapter extends TypeAdapter<List<Double>> {

  @Override
  public void write(final JsonWriter writer, final List<Double> doubles) throws IOException {
    writer.beginArray();
    for (final double value : doubles) {
      writer.value(value);
    }
    writer.endArray();
  }

  @Override
  public List<Double> read(final JsonReader reader) throws IOException {
    final List<Double> doubles = new ArrayList<>();

    if (reader.peek() == JsonToken.BEGIN_ARRAY) {
      reader.beginArray();
      while (reader.hasNext()) {
        doubles.add(reader.nextDouble());
      }
      reader.endArray();
    } else {
      doubles.add(reader.nextDouble());
    }
    return doubles;
  }
}