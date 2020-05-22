JSONObject pages = new JSONObject(json.getJSONObject("pages"));

// Use this to get IDs
Iterator<String> keys = pages.keys();

// Then iterate
while (keys.hasNext()) {
  JSONObject page = new JSONObject(pages.get(keys.next()));
  // Do something with the page
}