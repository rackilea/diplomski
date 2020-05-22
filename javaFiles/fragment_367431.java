String json = "{\n" +
              "    \"objectList\" : \"[{...}, {...}, ...]\", \n" +
              "    \"metadata\" : \"{...}\"    \n" +
              "}";

JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

System.out.println(jsonObject.get("objectList").getAsString());