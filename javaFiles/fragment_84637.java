@Override
 public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
     LoginResponse loginResponse = response.body();
     Toast.makeText(context, loginResponse.getStatusMessage (), Toast.LENGTH_LONG).show();
     Toast.makeText(context, loginResponse.getType (), Toast.LENGTH_LONG).show();
 }