@Override
public void onResponse(Call<Login> call, Response<Login> response) {
// String status=response.body().getStatus().toString();
   if (response !=null && response.isSuccessful()) {
         String status = response.body().getStatus();
             if(status=="success") {
                 progressDialog.dismiss();
                 Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                 Intent mainIntent;
                 mainIntent = new Intent(LoginActivity.this, DeviceControlActivity.class);
                 startActivity(mainIntent);
                 finish();
               }