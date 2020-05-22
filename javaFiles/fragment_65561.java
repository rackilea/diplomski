try {
    JSONObject yog = new JSONObject(response);
    JSONObject loginObject = new JSONObject(yog.getString("loginResult")); 
    int yogs=loginObject.getInt("UserID");
    System.out.println(yogs);
    }
catch (JSONException e) {
    e.printStackTrace();
}