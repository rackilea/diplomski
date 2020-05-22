JSONArray jsonarray = new JSONArray(jsonStr);
    for (int i = 0; i < jsonarray.length(); i++) {
        JSONObject jsonobject = jsonarray.getJSONObject(i);
        String number = jsonobject.getString("number");
        String updated_at = jsonobject.getString("updated_at");
        String created_at = jsonobject.getString("created_at");
        String id = jsonobject.getString("id");
        String message = jsonobject.getString("message");
        String status = jsonobject.getString("status");
                }