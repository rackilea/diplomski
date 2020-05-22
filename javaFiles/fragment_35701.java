ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

Call<TrackDetailsModel> call = apiInterface.getDatum();

    call.enqueue(new Callback<TrackDetailsModel>() {
    @Override
    public void onResponse(Call<TrackDetailsModel> call, Response<TrackDetailsModel> response) {
            if (response.isSuccessful()) {
                 TrackDetailsModel model = response.body();
                 String trackTitle = model.getTracks().getData().getTitle();

                    }
                }

    @Override
    public void onFailure (Call <TrackDetailsModel> call, Throwable t){
          call.cancel();
          Toast.makeText(Main.this,"Error: " + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });