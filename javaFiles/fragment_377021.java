RestApi.getUnicsAgencyApi().getStreams().enqueue(new Callback<List<AgencyModel>>() {

            @Override
            public void onFailure(Call<List<AgencyModel>> arg0, Throwable arg1) {
                // TODO Auto-generated method stub

                Log.e("Error in parsing", arg0.toString());
            }

            @Override
            public void onResponse(Call<List<AgencyModel>> AgencyModelData, Response<List<AgencyModel>> response) {
                // TODO Auto-generated method stub

                // ADD TO List here!!!!!!!!
                mstreamData.addAll(response.body());
                Log.e("Response", response.body().toString());
            }

        });