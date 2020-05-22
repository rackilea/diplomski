try {
  InputStream stream = new FileInputStream("c:\\filename.txt");
  JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
  Gson gson = new Gson();

  // Read file in stream mode
  reader.beginArray();
  while (reader.hasNext()) {
    CarInfo carInfo = gson.fromJson(reader, CarInfo.class);
  }
  reader.endArray();
  reader.close();
} catch (UnsupportedEncodingException ex) {
  ...
} catch (IOException ex) {
  ...
}