apiRequests.getApi().getURL()
            .map(new Func1<CreateUserResponse, List<Arg>>() {
                public List<Arg> call(CreateUserResponse response) {
                    return test(response.getURL());
                }
            })
            .subscribeOn(Schedulers.newThread())
            .observerOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<List<Arg>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(List<Arg> params) {

                }