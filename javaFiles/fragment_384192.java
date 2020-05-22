class TestTypeAdapter extends TypeAdapter<Test> {

    @Override
    public void write(JsonWriter out, Test value) throws IOException {
        throw new IllegalStateException("Implement me!");
    }

    @Override
    public Test read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        Test test = new Test();

        try {
            in.beginObject();
            while (in.hasNext()) {
                String name = in.nextName();
                if (name.equals("foo")) {
                    test.setFoo(in.nextString());
                    break;
                }
            }
        } catch (IllegalStateException e) {
            throw new JsonSyntaxException(e);
        }

        return test;
    }
}