private Consumer<Response<Void>> responseRxHandler = new Consumer<Response<Void>>() {
  @Override
  public void accept(Response<Void> response) throws Exception {
      final int responseCode = response.code();
      // TODO: Do whatever you want with the response code.
  }
};