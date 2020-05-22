Completable combinedCall(int param1, boolean param2) {
    return makeHttpCall(param1, param2)
            .flatMapCompletable(new Function<Data, CompletableSource>() {
                @Override
                public CompletableSource apply(@NonNull Data d) throws Exception {
                    return storeInDatabase(d);
                }
            });
}