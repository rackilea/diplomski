JSONArray details = obj.getJSONArray("data");
 for (int i=0; i<details.length(); i++) {
      JSONObject object = details.getJSONObject(i);
      String email = object.getString("email");
      Log.d("sample_email", email);
     }