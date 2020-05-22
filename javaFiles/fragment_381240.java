private static final Gson gson = new Gson();

private static final Type channelViewListType = new TypeToken<List<ChannelView>>() {
}.getType();

static Data testUsingDeserializationWithJsonAdapter(final Reader reader) {
    final List<MyObject> objects = gson.<List<ChannelView>>fromJson(reader, channelViewListType)
            .stream()
            .filter(Objects::nonNull)
            .map(view -> view.data)
            .filter(Objects::nonNull)
            .map(view -> view.value)
            .filter(Objects::nonNull)
            .map(view -> view.instruments)
            .flatMap(Collection::stream)
            .collect(toList());
    return new Data(objects);
}


private static final class ChannelView {

    final DataView data = null;

}

private static final class DataView {

    final ValueView value = null;

}

private static final class ValueView {

    @JsonAdapter(UnpackedJsonTypeAdapterFactory.class)
    final List<MyObject> instruments = null;

}

private static final class UnpackedJsonTypeAdapterFactory
        implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        return new UnpackedJsonTypeAdapter<>(gson.getAdapter(typeToken));
    }

    private static final class UnpackedJsonTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<T> typeAdapter;

        private UnpackedJsonTypeAdapter(final TypeAdapter<T> typeAdapter) {
            this.typeAdapter = typeAdapter;
        }

        @Override
        @SuppressWarnings("resource")
        public void write(final JsonWriter out, final T value)
                throws IOException {
            out.value(typeAdapter.toJson(value));
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            final String json = in.nextString();
            final JsonReader lenientIn = new JsonReader(new StringReader(json));
            lenientIn.setLenient(true);
            return typeAdapter.read(lenientIn);
        }

    }

}