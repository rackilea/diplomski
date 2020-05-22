TypeAdapterFactory myCustomTypeAdapterFactory = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

                final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
                final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type); //

                return new TypeAdapter<T>() {

                    public void write(JsonWriter out, T value) throws IOException {
                        JsonElement tree = delegate.toJsonTree(value);
                        beforeWrite(value, tree);
                        elementAdapter.write(out, tree);
                    }

                    public T read(JsonReader in) throws IOException {
                        JsonElement tree = elementAdapter.read(in);
                        afterRead(tree);
                        return delegate.fromJsonTree(tree);
                    }

                    /**
                     * Modify {@code toSerialize} before it is written to
                     * the outgoing JSON stream.
                     */
                    protected void beforeWrite(T source, JsonElement toSerialize) {

                    }

                    /**
                     * Modify {@code deserialized} before it is parsed
                     */
                    protected void afterRead(JsonElement deserialized) {
                        if(deserialized instanceof JsonObject) {
                            JsonObject jsonObject = ((JsonObject)deserialized);
                            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                            for(Map.Entry<String,JsonElement> entry : entrySet){
                                if(entry.getValue() instanceof JsonPrimitive) {
                                    if(entry.getKey().equalsIgnoreCase("linkedTo")) {
                                        String val = jsonObject.get(entry.getKey()).toString();
                                        jsonObject.addProperty(entry.getKey(), val.toLowerCase());
                                    }
                                } else {
                                    afterRead(entry.getValue());
                                }
                            }
                        }
                    }
                };
            }
        };