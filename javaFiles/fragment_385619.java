try {
    result = new JSONArray(ServerResponse);
    eventDetails(result);
} catch (JSONException e) {
    e.printStackTrace();
}