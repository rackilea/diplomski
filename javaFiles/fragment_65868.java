public static void main(String args[]) {
  String json = "{\"other_data\":{\"id\":\"150\",\"name\":\"AA\"},\"specification\":{\"result\":{\"feature\":[{\"name\":\"attribute A\",\"value\":\"50\"}]}}}";
  Gson gson = new Gson();
  Page result = gson.fromJson(json, Page.class);

  System.out.println(result.specification.get("result").get("feature").get(0).get("value"));