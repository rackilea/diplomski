public static <T> T fromJsonToJava(String jsonUrl, Class<T> type) throws IOException {
      URL url = new URL(jsonUrl);
      URLConnection conn = url.openConnection();
      InputStream in = conn.getInputStream();         
      Reader reader = new InputStreamReader(in);
      Gson gson = new Gson();
      return gson.fromJson(reader, type);

}