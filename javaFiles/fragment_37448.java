final class FilterTypeAdapterFactory
        implements TypeAdapterFactory {

    // This is a strategy up to your needs: resolve a java.lang.reflect.Type by a filter object content 
    private final Function<? super JsonObject, ? extends Type> typeResolvingStrategy;

    private FilterTypeAdapterFactory(final Function<? super JsonObject, ? extends Type> typeResolvingStrategy) {
        this.typeResolvingStrategy = typeResolvingStrategy;
    }

    static TypeAdapterFactory getFilterTypeAdapterFactory(final Function<? super JsonObject, ? extends Type> typeResolvingStrategy) {
        return new FilterTypeAdapterFactory(typeResolvingStrategy);
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Is it the Filter class?
        if ( Filter.class.isAssignableFrom(typeToken.getRawType()) ) {
            // Get the JsonObject type adapter
            final TypeAdapter<JsonObject> jsonObjectTypeAdapter = gson.getAdapter(JsonObject.class);
            // This is a function to resolve a downstream type adapter by the given type
            // If a downstream parser is not used, then the lookup will end up with self-recursion...
            final Function<Type, TypeAdapter<T>> typeTypeAdapterFunction = type -> {
                // Create a type token dynamically
                @SuppressWarnings("unchecked")
                final TypeToken<T> delegateTypeToken = (TypeToken<T>) TypeToken.get(type);
                // And get the downstream type adapter
                return gson.getDelegateAdapter(this, delegateTypeToken);
            };
            return new FilterTypeAdapter<>(jsonObjectTypeAdapter, typeTypeAdapterFunction, typeResolvingStrategy);
        }
        // Not a thing we can handle? Return null, and Gson will try to perform lookup itself
        return null;
    }

    private static final class FilterTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<JsonObject> jsonObjectTypeAdapter;
        private final Function<? super Type, ? extends TypeAdapter<T>> typeAdapterResolver;
        private final Function<? super JsonObject, ? extends Type> typeResolvingStrategy;

        private FilterTypeAdapter(
                final TypeAdapter<JsonObject> jsonObjectTypeAdapter,
                final Function<? super Type, ? extends TypeAdapter<T>> typeAdapterResolver,
                final Function<? super JsonObject, ? extends Type> typeResolvingStrategy
        ) {
            this.jsonObjectTypeAdapter = jsonObjectTypeAdapter;
            this.typeAdapterResolver = typeAdapterResolver;
            this.typeResolvingStrategy = typeResolvingStrategy;
        }

        @Override
        public void write(final JsonWriter out, final T value) {
            // If you ever need it, then you have to implement it
            throw new UnsupportedOperationException();
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            // Read the next {...} and convert it to JsonObject
            final JsonObject jsonObject = jsonObjectTypeAdapter.read(in);
            // Now resolve a real type by the given JsonObject instance
            // ... and resolve its type adapter
            final TypeAdapter<T> delegateTypeAdapter = typeAdapterResolver.apply(typeResolvingStrategy.apply(jsonObject));
            // Since the reader has the {...} value already consumed, we cannot read it at this moment
            // But we can convert the cached JsonObject to the target type object
            return delegateTypeAdapter.fromJsonTree(jsonObject);
        }

    }

}