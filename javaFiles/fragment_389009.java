mAPIService.loginUser(userName, userPassword, userRememberMe).enqueue(new Callback<JsonObject>() {
    @Override
public void onResponse(Response<JsonObject> response, Retrofit retrofit) {
       if(response.isSuccess()) {
         try {

           String token=response.body().get("data").get("token");
        } catch (JSONException e) {
              e.printStackTrace();
         }
Intent intent = new Intent(LoginActivity.this,ProfileActivity.class);
startActivity(intent);
    }
}
}