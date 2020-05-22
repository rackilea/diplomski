apiInstance.makeAPIRequest(new Response.Listener<JSONObject>(){

  @Override
  public void onResponse(JSONObject response){
     // do stuff
  }, 
  new Response.ErrorListener(){
   @Override
   public void onErrorResponse(VolleyError error){
    ...
   }
 });