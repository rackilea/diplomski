public Observable<Boolean> insertObject(Measurements m) {
    return Observable.create(new ObservableOnSubscribe<Boolean>() {
        @Override
        public void subscribe(ObservableEmitter<Boolean> e) {
            appDb.measurementDAO().insertMeasurements(m);
            e.onNext(true);
            e.onComplete();
        }
    }).subscribeOn(Schedulers.io());            

}