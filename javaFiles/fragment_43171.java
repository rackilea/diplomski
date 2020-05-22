class WebElemetsPossAdapter extends TypeAdapter<WebElemetsPoss> {
    @Override
    public WebElemets read (JsonReader reader) throws IOException {
        int screenWidth = 0, screenHeight = 0;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("screenWidth")) {
                screenWidth = (int)reader.nextDouble();
            } else if (name.equals("screenHeight")) {
                screenHeight = (int)reader.nextDouble();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new WebElemets(screenWidth, screenHeight);
    }

    @Override
    public void write(JsonWriter out, WebElemets value) throws IOException {
    }
}

//...

Gson gson = new GsonBuilder().registerTypeAdapter(WebElemetsPoss.class, new WebElemetsPossAdapter()).create();
//...