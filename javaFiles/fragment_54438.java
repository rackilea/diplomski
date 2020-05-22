private void idCategory(String ip){
    Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.login)).addConverterFactory(GsonConverterFactory.create()).build();
    JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    Call<List<ListeCategories>> call = jsonPlaceHolderApi.getIdCategory(ip);
    call.enqueue(new Callback<List<ListeCategories>>() {
        @Override
        public void onResponse(Call<List<ListeCategories>> call, Response<List<ListeCategories>> response) {
            final List<ListeCategories> chaines = response.body();
            for(ListeCategories chaine:chaines){
                mots = chaine.getLiveTV().split(",");
                for (int i = 0; i < mots.length; i++) {
                    Constants.idcategory.add(Integer.parseInt(mots[i]));

                }
                break;
            }
            showDialog()
        }

        @Override
        public void onFailure(Call<List<ListeCategories>> call, Throwable t) {

        }
    });

private void showDialog() {
    String message = String.valueOf(Constants.idcategory.size());
    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //do things
                }
            });
    AlertDialog alert = builder.create();
    alert.show();



}