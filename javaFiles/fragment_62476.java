private Location searchForLocation() {
    // of course you will return not null location
    return null;
}

// your task X
//mock your location fetching
private Observable<Location> getLocationObservableX() {
    return Observable.fromCallable(() -> searchForLocation());
}

//your task Y
//replace CustomData with simple String
//just to mock your asynchronous retrofit call
private Observable<List<String>> getRetrofitCallObservableY(String param){
    return Observable.just(new ArrayList<String>());
}


//subscribe
private void initialize() {
    getLocationObservableX()
            .filter(location -> {
                //place your if else here
                //condition
                //don't continue tu retrofit
                boolean condition = false;

                if (condition) {
                    //process
                    //quit and pass that Location in Broadcas
                    //you shall return false if you don't want to continue
                    return false;
                }
                return true;
            })
            //filter operation does not continue here if you return false
            .flatMap(location -> getRetrofitCallObservableY("param"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(response -> {
                //do what you want with response
            });
}