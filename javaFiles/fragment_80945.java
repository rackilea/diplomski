RetrofitClient client = new RetrofitClient(BASE_URL);
client.getServies().sendSMS("+923418007173").enqueue(new Callback<Sms>(){

                        @Override
                        public void onResponse(Call<Sms> call, Response<Sms> response) {
                            Toast.makeText(getApplicationContext(), mPhone, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Sms> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                        }
                    });