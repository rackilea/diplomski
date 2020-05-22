Observable<List<TestModel2>> observable = apiTest
.performTest()
.flatMapIterable(items -> items)
.flatMap(testModel -> 
    apiTest.performTest2(testModel.userId)
    .onErrorResumeNext(e -> apiTest.performTest3(testModel.userId)); // <----------------
)
.doOnNext(testModel2 -> {
    Log.d("TestItemData", "doOnNext --- " + testModel2.title);
})
.onErrorResumeNext(throwable ->{
    Log.d("TestItemData", "onErrorResumeNext -------- ");
    return Observable.empty();
})
.toList()
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread());