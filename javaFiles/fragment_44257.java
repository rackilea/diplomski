public class RatedAdapter extends TypeAdapter<Rated> {

    public Rated read(JsonReader reader) throws IOException {
        reader.beginObject();
        reader.nextName();

        Rated rated;
        try {
            rated = new Rated(reader.nextDouble());
        } catch (IllegalStateException jse) {
            // We have to consume JSON document fully.
            reader.nextBoolean();
            rated = null;
        }

        reader.endObject();

        return rated;
    }

    public void write(JsonWriter writer, Rated rated) throws IOException {
        if (rated == null) {
            writer.value("false");
        } else {
            writer.value(rated.value);
        }
    }
}