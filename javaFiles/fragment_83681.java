LoginDTO loginDTO = new LoginDTO(
            etPhno.getText().toString().trim(),
            etPass.getText().toString().trim()
    );

ApiService service = ApiClient.getApiClient().getClient().create(ApiService.class);
Call<LoginResp> call = service.loginAPI(loginDTO);
call.enqueue(new Callback<LoginResp>() {

    @Override
    public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {

        LoginResp loginResp = response.body();

    }

    @Override
    public void onFailure(Call<LoginResp> call, Throwable t) {

        Toast.makeText(Login.this, "Error here", Toast.LENGTH_SHORT).show();
    }
});