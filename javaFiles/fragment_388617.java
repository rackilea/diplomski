apiInterface = new Retrofit.Builder()
                        .baseUrl(BASE_URL_ANDROIDHIVE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ApiInterface.class);

                final Call<List<AndroidHive>> hiveCall = apiInterface.getAllMovies();

                hiveCall.enqueue(new Callback<List<AndroidHive>>() {
                    @Override
                    public void onResponse(Call<List<AndroidHive>> call, Response<List<AndroidHive>> response) {

                        if (response.isSuccessful()) {
                            progressDialog.dismiss();
                            List<AndroidHive> hiveList = response.body();

                            tv_retrofit.setText("Title : " + hiveList.get(3).getTitle() + "\n Image : " + hiveList.get(3).getImage() + "\n Rating : " + hiveList.get(3).getRating() + " \n Release Year : " + hiveList.get(3).getReleaseYear() + "\n  Gener : " + hiveList.get(3).getGenre());

                        } else {
                            Toast.makeText(getActivity(), "Response Failed Code : " + response.message(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AndroidHive>> call, Throwable t) {
                        System.out.println(t.getStackTrace().toString());
                        progressDialog.dismiss();
                    }
                });