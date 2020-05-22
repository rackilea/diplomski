JSONArray newButtons = new JSONArray();
for (int i = 0; i < buttons.size(); i++) {
    JsonObject button = buttons.getJsonObject(i);
    newButtons.put(new org.json.JSONObject(button.toString()));
}
return newButtons;