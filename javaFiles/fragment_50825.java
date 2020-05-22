private void getLogin() {
    Call<LoginResponse> call = jsonPlaceHolderApi.getLogin();

    call.enqueue(new Callback<LoginResponse>() {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            if (!response.isSuccessful()) {
                http://retailapi.airtechsolutions.pk/api/login/admin@gmail.com/

                Log.i("Code: ", String.valueOf(response.code()));
                return;
            }

            LoginResponse loginResponse = response.body();


            String content = "";
            content += "UserName: " + loginResponse.user.getUsername() + "\n";
            content += "Password: " + loginResponse.user.getPassword() + "\n";
            content += "Status: " + loginResponse.getStatus() + "\n";
            content += "Description: " + loginResponse.getDescription() + "\n\n";

            Log.i("Read me", content);
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            Log.i("Error", t.getMessage());
        }

    });
}

private void createPost() {
    User login = new User("New Name", "New Password");

    Call<LoginResponse> call = jsonPlaceHolderApi.createPost(login);

    call.enqueue(new Callback<LoginResponse>() {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

            if (!response.isSuccessful()) {
                Log.i("Code: ", String.valueOf(response.code()));
                return;
            }

            LoginResponse loginResponse = response.body();

            String content = "";
            content += "Code: " + response.code() + "\n";
            content += "UserName: " + loginResponse.user.getUsername() + "\n";
            content += "Password: " + loginResponse.user.getPassword() + "\n";
            content += "Status: " + loginResponse.getStatus() + "\n";
            content += "Description: " + loginResponse.getDescription() + "\n\n";

            Log.i("Read me", content);
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            Log.i("Failure", t.getMessage());
        }
    });
}