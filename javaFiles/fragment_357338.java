public void sendPhotosAndSave(List<Photo> photos) {
        Observable.from(photos)
                .flatMap(photo -> sendRequest(photo).subscribeOn(Schedulers.io()))
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {
                        // Save
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                    }
                });
    }

    private Observable<Boolean> sendRequest(Photo photo) {
        return Observable.just(/*your request logic*/);
    }