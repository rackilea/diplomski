class TranslationTypeAdapter extends TypeAdapter<List<Translation>> {
    @Override
    public void write(JsonWriter out, List<Translation> list) throws IOException {
        out.beginObject();
        for(Translation t : list) {
            out.name(t.locale).value(t.text);
        }
        out.endObject();
    }

    @Override
    public List<Translation> read(JsonReader in) throws IOException {
        List<Translation> list = new ArrayList<>();
        in.beginObject();
        while(in.hasNext()) {
            list.add(new Translation(in.nextName(), in.nextString()));
        }
        in.endObject();
        return list;
    }
}