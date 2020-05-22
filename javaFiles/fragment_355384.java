@Override
public Observable<List<Data>> loadDataObservable() {
    return Observable.just(generateData()).delay(500, TimeUnit.MILLISECONDS);
}

private List<Data> generateData(){
    List<Data> dataList = new ArrayList<Data>();
    for (int i = 0; i < 20; i++) {
        Data data = new Data("key"+i, "value"+i);
        dataList.add(data);
    }
    return dataList;
}