String content = "{\"content\":[{\"name\":\"abc\"},{\"name\":\"bcd\"},{\"name\":\"xyz\"}]}";
    JSONObject jsonObject = new JSONObject(content);
    JSONArray jsonArray = jsonObject.getJSONArray("content");
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        System.out.println(object.getString("name"));
    }