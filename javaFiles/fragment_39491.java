db.userDao().insert(user)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(Long aLong) {
                // aLong is the id
            }
            @Override
            public void onError(Throwable e) {
            }
        });