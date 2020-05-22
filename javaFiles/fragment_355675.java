public class AuthService {
     private Context ctx;
     private OnLoginCallback callback;
     private Boolean userloggedin = false;

      public AuthService(Context cnt){
        ctx = cnt;
        callback =(OnLoginCallback) cnt;
     }

   public boolean  login(String loginurl, JSONObject loginparams){

      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
              (Request.Method.POST, loginurl, loginparams,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //set access tokens here
                            Log.i("test","successifully"+response);
                            userloggedin = true;
                            callback.onLoginCallback(true);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    userloggedin = false;
                      callback.onLoginCallback(false);
                }
            }
            );


    // Access the RequestQueue through your singleton class.
    ApiSingleton strngle = new ApiSingleton(ctx);
    strngle.addToRequestQueue(jsonObjectRequest);

    return userloggedin;
  }

}


interface OnLoginCallback{
    void onLoginCallback(boolean loggedin);
}