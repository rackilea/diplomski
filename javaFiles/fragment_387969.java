public void getUserList(){
        GetUsers users = RetrofitInstance.getRetrofitInstance().create(GetUsers.class);
        Call<JsonObject> call = users.getUserList("myUsername");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                PassUsersToJavaScript(response.body().getList());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }