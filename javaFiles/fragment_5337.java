JSONObject myObject = new JSONObject();
 myObject.JSONObject myObject = new JSONObject();
 try {
   myObject.put("name", "Agamemnon");
   myObject.put("age", 32);
 } 
 catch (JSONException ex) {
   LOGGER.log(Level.SEVERE, "Error ...", ex);
 }