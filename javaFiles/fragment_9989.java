public static void addChecked(JSONArray ja) throws JSONException {
    for (int i = 0; i < ja.length(); i++) {
        JSONObject jo = (JSONObject) ja.get(i);
        if (jo.has("children"))
            addChecked((JSONArray) jo.get("children"));

        jo.put("checked", false);
    }
}

public static void main(String[] args) throws Exception {
    String jsonString = "[{\"text\":\"Millions\", \"children\":[{\"text\":\"Dinosaur\", \"children\":[{\"text\":\"Stego\"}]}, {\"text\":\"Dinosaur\", \"children\": [{\"text\":\"T-REX\"}]}]}]";
    JSONArray jsonArray = new JSONArray(jsonString);
    System.out.println(jsonString);
    addChecked(jsonArray);
    System.out.println(jsonArray);
}