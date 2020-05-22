apiClient
.getOrder(id)
.subscribeOn(Schedulers.io())
.flatMapIterable(Order::getLineItems)
.flatMap(lineItem ->
    apiClient.getProduct(lineItem.getProductId())
             .subscribeOn(Schedulers.io())
             .map(product -> product.getCurrentPrice() * lineItem.getCount()),
    5)
.reduce((a,b)->a+b)
.retryWhen((e, count) -> count<2 && (e instanceof RetrofitError))
.onErrorReturn(e -> -1)
.subscribe(System.out::println);