class ResponseTypeAdapter extends TypeAdapter<Response> {
    @Override
    public void write(JsonWriter out, Response value) throws IOException {
        out.beginObject();
        out.name("value");
        // check for null, if applicable, and use a default value, or don't write anything at all
        out.value(value.getValue().getPrice());
        out.endObject();
    }

    @Override
    public Response read(JsonReader in) throws IOException {
        // implement the deserialization
    }
}