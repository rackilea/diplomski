String s = "";
    JSONArray jArray = new JSONObject(result).getJSONArray("the_name_of_your_json_array");
    for (int i = 0; i < jArray.length(); i++) {
        JSONObject json = jArray.getJSONObject(i);
        s = s + "Name : " + json.getString("name") + "\n" + "Email : " + json.getString("email") + "\n\n";
    }