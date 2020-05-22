public void loginRequest(){

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    networkAPI = retrofit.create(NetworkAPI.class);

    LoginRequest loginRequest = new LoginRequest(yourusername,yourpassword);

    Call<JsonElement> call = networkAPI.loginRequest(loginRequest);

    call.enqueue(new Callback<JsonElement>() {
        @Override
        public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
            // success response

        }

        @Override
        public void onFailure(Call<JsonElement> call, Throwable t) {
           // failure response
        }
    });
}