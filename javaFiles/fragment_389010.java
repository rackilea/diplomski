mAPIService.loginUser(userName, userPassword, userRememberMe).enqueue(new Callback<ResponseData>() {
    @Override
    public void onResponse(Response<ResponseData> response, Retrofit retrofit) {
        if(response.isSuccess()) {
            //save token here
String token =response.getData().getToken();

            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e(TAG, "Unable to Login");
    }
});