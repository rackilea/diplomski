@Override public Object read(JsonReader in) throws IOException {
    JsonToken token = in.peek();
    switch (token) {
    ...
    case BEGIN_OBJECT:
      Map<String, Object> map = new LinkedTreeMap<String, Object>(); // <-----
      in.beginObject();
      while (in.hasNext()) {
        map.put(in.nextName(), read(in));
      }
      in.endObject();
      return map;   // <-----
    ...
  }