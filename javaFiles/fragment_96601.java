JSONArray jSONArray = new JSONArray("your input array");
  int length = jSONArray.length();
  for (int i = 0; i < length; i++) {
        JSONObject jSONObject= jSONArray.getJSONObject(i);
        System.out.println(jSONObject.get("docmanId"));
        System.out.println(jSONObject.get("dz"));
    }