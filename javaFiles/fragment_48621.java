String name = "";
JSONObject serverJSON = new JSONObject(YOUR_JSON_RESPONSE_STRING_FROM_SERVER);

try {
     JSONObject nameObject = serverJSON.getJSONObject("name");
     if (nameObject.has("first_name")) {
         name = nameObject.getString("first_name") + " ";
     }

     if (nameObject.has("middle_name")) {
         name += nameObject.getString("middle_name") + " ";
     }

     if (nameObject.has("last_name")) {
         name += nameObject.getString("last_name");
     }

     name = name.trim();
} catch (JSONException e) {
     // Probably a String, try again...
     try { 
          name = serverJSON.getString("name");
     catch (JSONException e) {
          // Not a String or a JSONObject... figure out what's wrong...
          e.printStackTrace();
     }
}