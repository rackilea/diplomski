JSONObject records = response.getJSONObject("data");
 JSONArray users = records.getJSONArray("users");

  for (int j = 0; j < users.length(); j++) {
          JSONObject v_obj = users.getJSONObject(j);
           Log.d("Dracula", v_obj.getString("id"));
           Log.d("Dracula", v_obj.getString("name"));
           Log.d("Dracula", v_obj.getString("email"));
  }