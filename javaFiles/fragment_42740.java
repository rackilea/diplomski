ConcurrentLinkedQueue<Product> products = new ConcurrentLinkedQueue<Product>();
final Executor callbackExecutor = Executors.newSingleThreadExecutor();
final CountDownLatch doneSignal = new CountDownLatch(/*the Map size*/);
for (// iterating over a Map) {
    key = entry.getKey();
    String query = "SELECT id,desc,category FROM products where id=?";
    ResultSetFuture future = session.executeAsync(query, key);
    Futures.addCallback(future,
        new FutureCallback<ResultSet>() {
            @Override public void onSuccess(ResultSet result) {
                Row row = result.one();
                if (row != null) {
                    Product product = new Product();
                    product.setId(row.getString("id"));
                    product.setDesc(row.getString("desc"));
                    product.setCategory(row.getString("category"));

                    products.add(product);
                }
                doneSignal.countDown();

            }

            @Override public void onFailure(Throwable t) {
                // log error
                doneSignal.countDown();
            }
        },
        callbackExecutor
    );
}

doneSignal.await();           // wait for all async requests to finish
System.out.println("Product List : " + products);