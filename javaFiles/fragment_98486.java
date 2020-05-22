public class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create (final Gson gson, final TypeToken<T> type) {
        if (type.getRawType () != SuperType.class)
            return null;

        final TypeAdapter<T> delegate = gson.getDelegateAdapter (this, type);

        return new TypeAdapter<T> () {
            @Override
            public void write (final JsonWriter jsonWriter, final T t) throws IOException {
                delegate.write (jsonWriter, t);
            }

            @Override
            public T read (final JsonReader jsonReader) throws IOException, JsonParseException {
                JsonElement tree = Streams.parse (jsonReader);
                JsonObject object = tree.getAsJsonObject ();

                if (object.has ("a"))
                    return (T) readTypeA (tree, object.getAsJsonObject ("a"));

                if (object.has ("b"))
                    return (T) readTypeB (tree, object.getAsJsonObject ("b"));

                throw new JsonParseException ("Cannot deserialize " + type + ". It is not a valid SuperType JSON.");
            }

            private TypeA readTypeA (final JsonElement tree, final JsonObject a) {
                if (a.has ("aa"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeA_A.class)).fromJsonTree (tree);

                if (a.has ("ab"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeA_B.class)).fromJsonTree (tree);

                if (a.has ("ac"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeA_C.class)).fromJsonTree (tree);

                throw new JsonParseException ("Cannot deserialize " + type + ". It is not a valid TypeA JSON.");
            }

            private TypeB readTypeB (final JsonElement tree, final JsonObject b) {
                if (b.has ("ba"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeB_A.class)).fromJsonTree (tree);

                if (b.has ("bb"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeB_B.class)).fromJsonTree (tree);

                if (b.has ("bc"))
                    return gson.getDelegateAdapter (CustomTypeAdapterFactory.this, TypeToken.get (TypeB_C.class)).fromJsonTree (tree);

                throw new JsonParseException ("Cannot deserialize " + type + ". It is not a valid TypeB JSON.");
            }
        };
    }
}