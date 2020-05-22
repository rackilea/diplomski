ArrayList<Map<String, Object>> data = new ArrayList<>(info.size());
Map<String, Object> m;
JSONObject current;
for (int i = 0; i < info.size(); i++) {
  m = new HashMap<String, Object>();
  current = (JSONObject) info.get(i);

  m.put("title", (String) current.get("title"));
  m.put("url", (String) current.get("url"));
  data.add(m);
}