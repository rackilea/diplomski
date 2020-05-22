public class DurationTypeAdapter extends TypeAdapter<Duration> {
  public void write(JsonWriter writer, Duration value) throws IOException {
    if (value == null) {
      writer.nullValue();
      return;
    }

    writer.value(duration.getStandardSeconds());
  }

  // implementation of read() is left as an exercise to you
}