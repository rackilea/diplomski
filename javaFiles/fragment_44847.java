List<StylistArray> list = new ArrayList<>();
// assume you have add all items to the list.

JSONArray jsonArray = new JSONArray();
try {
  // You need to use simple for loop instead the following foreach
  // because foreach is slower than traditional loop.
  for (StylistArray stylistArray : list) {
    // create JSON object for each item
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("stylist", stylistArray.getStylist());
    jsonObject.put("endTime", stylistArray.getEndTime());

    // append it to your JSON array.
    jsonArray.put(jsonObject);
  }
} catch (JSONException e) {
  e.printStackTrace();
  // Error happens, try to handle it.
}