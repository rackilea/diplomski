Gson gson = new GsonBuilder().registerTypeAdapter(Type.class,
            new TypeAdapter<Type>() {

                @Override
                public void write(JsonWriter out, Type value)
                        throws IOException {
                    out.value(value.name().toLowerCase());
                }

                @Override
                public Type read(JsonReader in) throws IOException {
                    return Type.valueOf(in.nextString().toUpperCase());
                }
            }).create();