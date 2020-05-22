public String getHistory(UUID uuid) throws Exception {
    String history = "";
    HttpURLConnection connection = (HttpURLConnection) new URL("https://api.mojang.com/user/profiles/"+uuid.toString().replace("-", "")+"/names").openConnection();
    JSONArray response = (JSONArray) jsonParser.parse(new InputStreamReader(connection.getInputStream()));
    for(int index = 1; index < response.size(); index++) {
        JSONObject jsonObject = response.get(index);
        String name = (String) jsonObject.get("name");
        if(index < response.size()) {
            history = history + name + ",";
        } else {
            history = history + name + ".";
        }
    }
    return history == "" ? history = "none." : history;
}