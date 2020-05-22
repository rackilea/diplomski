public abstract class ApiRepositorySource<RawResponse extends BaseResponse, ResultType> {

    // result is a Flowable because Room Database only returns Flowables
    // Retrofit response will also be folded into the stream as a Flowable
    private Flowable<ApiResource<ResultType>> result; 
    private AppDatabase appDatabase;

    @MainThread
    ApiRepositorySource(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
        Flowable<ApiResource<ResultType>> source;
        if (shouldFetch()) {
            source = createCall()
                .doOnNext(this::saveCallResult)
                .flatMap(apiResponse -> loadFromDb().toObservable().map(ApiResource::success))
                .doOnError(this::onFetchFailed)
                .onErrorResumeNext(t -> {
                    return loadFromDb()
                            .toObservable()
                            .map(data -> {
                                ApiResource apiResource;

                                if (t instanceof HttpException && ((HttpException) t).code() >= 400 && ((HttpException) t).code() < 500) {
                                    apiResource = ApiResource.invalid(t.getMessage(), data);
                                } else {
                                    apiResource = ApiResource.error(t.getMessage(), data);
                                }

                                return apiResource;
                            });
                })
                .toFlowable(BackpressureStrategy.LATEST);
        } else {
            source = loadFromDb()
                    .subscribeOn(Schedulers.io())
                    .map(ApiResource::success);
        }

        result = Flowable.concat(initLoadDb()
                            .map(ApiResource::loading)
                            .take(1),
                            source)
                .subscribeOn(Schedulers.io());
    }

    public Observable<ApiResource<ResultType>> asObservable() {
        return result.toObservable();
    }

    @SuppressWarnings("WeakerAccess")
    protected void onFetchFailed(Throwable t) {
        Timber.e(t);
    }

    @WorkerThread
    protected void saveCallResult(@NonNull RawResult resultType) {
        resultType.saveResponseToDb(appDatabase);
    }

    @MainThread
    protected abstract boolean shouldFetch();

    @NonNull
    @MainThread
    protected abstract Flowable<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Observable<RawResult> createCall();

    @NonNull
    @MainThread
    protected Flowable<ResultType> initLoadDb() {
        return loadFromDb();
    }
}