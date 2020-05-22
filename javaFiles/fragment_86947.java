public static Observable<List<Data>> getLoadedData()
{
    if (mLoadedObservable == null)
    {
        mLoadedObservable = getEmptyData().
                .map(new Func1<List<Data>, List<Data>>()
                {
                    @Override
                    public Data call(List<Data> data)
                    {
                        for (Data item : data) {
                           item.load();
                        }
                        return data;
                    }
                })
                // share and replay observable
                .share().replay();
    }
    return mLoadedObservable;
}