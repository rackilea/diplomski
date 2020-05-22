import org.json.JSONException;
  import org.json.JSONObject;

  try {
       JSONObject obj = new JSONObject(result);
       boolean error = obj.getBoolean("error");
       int volume = obj.getInt("volume");
  } catch (JSONException e){

  }