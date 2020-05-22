JSONArray properties = new JSONArray();
properties.put("resume");
properties.put("genre");
properties.put("studio");
...

JSONObject params = new JSONObject();
params.put("properties", properties);

obj.put("params", params);