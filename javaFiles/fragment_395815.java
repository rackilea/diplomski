public static void main(String []args) throws JSONException, JsonParseException, JsonMappingException, IOException{

    Map<String, Object> top = new HashMap<String, Object>();

    Map<String, Object> vars = new HashMap<String, Object>();
    vars.put("VAR","123");
    vars.put("OTHER_VAR","234");

    top.put("Variable", vars);

    Gson gson = new GsonBuilder().create();
    String jsonString = gson.toJson(top);
    System.out.println("JSON " + json);
}