for (int i = 0; i < j.length(); i++) {
    try {
        JSONObject json = j.getJSONObject(i);
        eventList.add(json.getString("EventName") + json.getString("EventDate");
    } catch (JSONException e) {
        //e.printStackTrace();
        Log.d(TAG, e.toString());
    }
}