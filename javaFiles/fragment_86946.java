private static  Observable<List<Data>> mEmptyObservable = null;
private static  Observable<List<Data>> mLoadedObservable = null;

public static Observable<List<Data>> getEmptyData()
{
    if (mEmptyObservable == null)
    {
        // simple test data
        List<Data> values = new ArrayList<>();
        mEmptyObservable = Observable.just(values)
                // share and replay observable
                .share().replay();
    }
    return mEmptyObservable;
}

public static Observable<List<Data>> getLoadedData()
{
    if (mLoadedObservable == null)
    {
        mLoadedObservable = getEmptyData()
                .flatMap(new Func1<List<Data>, Observable<Data>>()
                {
                    @Override
                    public Observable<Data> call(List<Data> datas)
                    {
                        return Observable.from(datas);
                    }
                })
                .map(new Func1<Data, Data>()
                {
                    @Override
                    public Data call(Data data)
                    {
                        data.load();
                        return data;
                    }
                })
                .toList()
                // share and replay observable
                .share().replay();
    }
    return mLoadedObservable;
}