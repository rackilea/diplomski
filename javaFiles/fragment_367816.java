List<Observable<T>> list = new ArrayList<>();
list.add(req1);
list.add(req2);

Observable.zip(list, new FuncN<???>() {
    @Override
    public ??? call(Object... args) {
        return ???;
    }
);