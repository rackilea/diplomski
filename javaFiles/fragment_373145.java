Call<product> call = ref.GetProduct();

call.enqueue(new Callback<product>() {
  @Override
  public void onResponse(Call<product> call, Response<product>
response) {               
   lst=response.body();

   txt3.setText(response.body().getFamily());
  }

  @Override
   public void onFailure(Call<product> call, Throwable t) {

   }
 });