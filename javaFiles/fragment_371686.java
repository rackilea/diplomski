private static Retrofit getValidatedDataTransferObjectsRetrofit() {
    final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new TypeAdapterFactory() {
                @Override
                public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                    if ( typeToken.getRawType() != User.class ) {
                        return null;
                    }
                    final TypeAdapter<T> delegateTypeAdapter = gson.getDelegateAdapter(this, typeToken);
                    return new TypeAdapter<T>() {
                        @Override
                        public void write(final JsonWriter out, final T value)
                                throws IOException {
                            if ( value instanceof User ) {
                                final User user = (User) value;
                                requireNonNull(user.name, "name must not be null");
                                requireNonNull(user.group, "group must not be null");
                            }
                            delegateTypeAdapter.write(out, value);
                        }

                        @Override
                        public T read(final JsonReader in)
                                throws IOException {
                            return delegateTypeAdapter.read(in);
                        }
                    };
                }
            })
            .create();
    return new Retrofit.Builder()
            .client(mockOkHttpClient)
            .baseUrl("http://whatever")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}