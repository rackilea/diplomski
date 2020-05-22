subscription = moviesResponseObservable
                .subscribeOn(Schedulers.io())
                .flatMapIterable(new Func1<MoviesResponse, Iterable<Result>>() {
                    @Override
                    public Iterable<Result> call(MoviesResponse moviesResponse) {
                        return moviesResponse.getResults();
                    }

                })
                .map(new Func1<Result, String>() {

                    @Override
                    public String call(Result result) {
                        return result.getTitle();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(LOG_TAG, s);
                    }
                });