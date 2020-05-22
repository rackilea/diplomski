interface Callback {
  void onProductsRetrieved(List<Product> products)
  void onProductsRetrieveError()
}

public static void getProducts(@NonNull Context context, Callback callback) {
  ProductDataSource
    .getInstance(context)
    .readProducts(new IProductDataSource.IReadProductsCallback() {
      @Override
      public void onSuccess(List<Product> result) {
        callback.onProductsRetrieved(result)
      }

      @Override
      public void onFailure() {
        callback.onProductsRetrieveError()
      }
    });
}