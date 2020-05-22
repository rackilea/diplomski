public abstract class LoginCheck {
public LoginCheck(){
    new Check().execute(true);
}
public  class Check extends AsyncTask<Boolean,Boolean,Boolean>{
 @Override
 protected Boolean doInBackground(Boolean... objects) {

     JSONStringer jsonSend = null;

     try {
         jsonSend = new JSONStringer()
                 .object()
                 .endObject();
     } catch (JSONException e) {
         Log.e("log_tag", "Error creating Json " + e.toString());
     }

     JSONObject result = JsonPost.postJSONtoURL(MyApp.getServiceUrl() + "/Api/Login/AmILoggedIn", jsonSend);

     try {
         if (result.getBoolean("Success")) {
             return true;
         }
     } catch (JSONException e) {
         Log.e("log_tag", "Error parsing data " + e.toString());
     }
     try {
         if (!result.getBoolean("Success")) {
             return false;
         }
     } catch (JSONException e) {
         Log.e("log_tag", "Error parsing data " + e.toString());
     }

     return false;
 }



 @Override
 protected void onPostExecute(Boolean result){
     if(result)
         LoggedIn();
     if(!result)
         LoggedOut();

 }
  }




public abstract void LoggedIn();
public abstract void LoggedOut();

 }