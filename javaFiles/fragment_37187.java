Observable<Integer> mergedObservers = firstAPI.getFirstInfo("1","2")
.flatMap(resultFirstObservable -> {
    return secondApi.getSecondInfo(resultFirstObservable, "3")
        .onErrorResumeNext(e -> {
             e.printStackTrace();
             return secondApi.getSecondInfo("defaultValue", "3");
        });
}, (resultFirstObservable, resultSecondObservable) -> {
    try {
        return transformToWhatINeed(resultSecondObservable.body().string());
    } catch (IOException ex) {
        ex.printStackTrace();
        return "";
    }
});