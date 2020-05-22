public class MyRequests{
   private jsonParser;
   public MyRequests(){
     jsonParser = new JSONParser()  

   }
   //request login
   public JSONObject loginRequest(String username,String password, String prgCode, String language){
     // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("prgCode", prgCode));
    params.add(new BasicNameValuePair("lang", language));
    JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);

    return json;
   }

    //request profile info
   public JSONObject profileRequest(String prgCode,String token){
     // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("prgCode", prgCode));
    params.add(new BasicNameValuePair("token", token));
    JSONObject json = jsonParser.getJSONFromUrl(profileURL, params);

    return json;
   }
}