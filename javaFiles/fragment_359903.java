public Observable<Item> get(View v) {
    return idApi.get().flatMap(new Function<List<String>, ObservableSource<String>>() {
        @Override
        public ObservableSource<String> apply(@NonNull List<String> ids) throws Exception {
            return Observable.fromIterable(ids);
        }
    }).zipWith(RxView.clicks(v).debounce(500, TimeUnit.MILLISECONDS), (n, i) -> n))    
    .flatMap(new Function<String, ObservableSource<Item>>() {
        @Override
        public ObservableSource<Item> apply(@NonNull final String id) throws Exception {
            return dataApi.get(id).map(new Function<Data, Item>() {
                @Override
                public Item apply(@NonNull Data data) throws Exception {
                    return new Item(data , id);
            });
        }
    });
}