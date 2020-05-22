private void loadJSON() {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("your BASE_URL")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    BankInterface request = retrofit.create(RequestInterface.class);
    Call<List<JsonItems>> call = request.getToken();
    call.enqueue(new Callback<List<JsonItems>>() {
        @Override
        public void onResponse(Call<List<JsonItems>> call, Response<List<JsonItems>> response) {
            List<JsonItems> jsonItems= response.body();
            String token = jsonItems.get(0).getIdToko();

        }

        @Override
        public void onFailure(Call<List<JsonItems>> call, Throwable t) {
            showToast("No Internet Connection");
        }


    });

}