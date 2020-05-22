try {
    JSONObject json = new JSONObject(readUrl("..."));

    String title = (String) json.get("title");
    ...

} catch (JSONException e) {
    e.printStackTrace();
}