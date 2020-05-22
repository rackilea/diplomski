public class PairAdapter extends TypeAdapter<Pair> {
    final Gson embedded = new Gson();

    public PairAdapter() {
        super();
    }

    @Override
    public void write(final JsonWriter out, final Pair value)
            throws IOException {
        out.beginObject();

        out.name("first");
        embedded.toJson(embedded.toJsonTree(value.getFirst()), out);

        out.name("second");
        embedded.toJson(embedded.toJsonTree(value.getSecond()), out);

        out.endObject();
    }

    @Override
    public Pair read(JsonReader in) throws IOException {
        throw new UnsupportedOperationException();
    }
}