public Observable<List<Value>> loadValues() {
    return
       apiProvider.map(new Func1<Api, List<Value>>() {
            @Override
            public List<Value> call(Api api) {
                return api.getValues();
            }
       });
}