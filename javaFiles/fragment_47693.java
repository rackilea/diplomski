final class RawStringTypeAdapter
        extends TypeAdapter<String> {

    // Gson can do it itself    
    private RawStringTypeAdapter() {
    }

    @Override
    public void write(final JsonWriter out, final String value)
            throws IOException {
        // not out.value(value)!
        out.jsonValue(value);
    }

    @Override
    public String read(final JsonReader in)
            throws IOException {
        return in.nextString();
    }

}