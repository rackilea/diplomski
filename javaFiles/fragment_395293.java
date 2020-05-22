Gson gson = new GsonBuilder().registerTypeAdapter(Action.class, new TypeAdapter<Action>() {

    @Override
    public void write(JsonWriter out, Action value) throws IOException {
        out.value(value.name().toLowerCase());
    }

    @Override
    public Action read(JsonReader in) throws IOException {
        return Action.valueOf(in.nextString().toUpperCase());
    }
}).create();