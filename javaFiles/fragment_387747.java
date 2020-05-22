public JSONObject getDayJson(Date date) {
  try { 
      ...
      a few lines of code
      ...
      return new JSONObject("..");
   } catch (Exception e) {
      // doesn't throw another exception
      return new JSONObject(new HashMap());
   }

}