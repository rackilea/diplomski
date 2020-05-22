private Callback<Response<Void>> responseHandler = new Callback<Response<Void>>() {
  @Override
  public void onResponse(Call<Response<Void>> call, Response<Response<Void>> response) {
    final int code = response.code();
    // TODO: Do whatever you want with the response code.
  }

  @Override
  public void onFailure(Call<Response<Void>> call, Throwable t) {
      // TODO: Handle failure.
  }
}