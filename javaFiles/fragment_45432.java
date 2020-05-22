JSONArray jArray = json.getJSONArray("pages");
MasteryPage[] arr = new MasteryPage[jArray.length()];
for (int i = 0; i < jArray.length(); i++) {
    JSONObject jsonMasteryPage = jArray.getJSONObject(i);
    long id = jsonMasteryPage.getLong("id");
    String name = jsonMasteryPage.getString("name");
    boolean current = jsonMasteryPage.getBoolean("current");
    MasteryPage page = new MasteryPage(id, name, current);
    JSONArray jsonMasteries = jsonMasteryPage.getJSONArray("masteries");
    for (int j = 0; j < jsonMasteries.length(); j++) {
        JSONObject jsonMastery = jsonMasteries.getJSONObject(i);
        page.addMastery(jsonMastery.getLong("id"), jsonMastery.getInt("rank"));
    }
    arr.add(page);
}