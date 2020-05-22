public String getNestedField() {
   Gson gson = new Gson();
   String [] split = response.split("\n");
   JsonParser p = new JsonParser();
   String json = split[0];
   BSONObject b = gson.fromJson(p.parse(json), BSONObject.class);
   return b.getWidget().getField();
}