countryListAsObservable.flatMap(new Func1<WebResponse<ArrayList<Country>>, Observable<?>>() {
    @Override
    public Observable<Country> call(final WebResponse<ArrayList<Country>> response) {
        if (!isValidResponse(response)) {
            return Observable.error(new Exception("Response is invalid"));
        } else {
            return Observable.from(response.getResult());
        }
    }

    public boolean isValidResponse(final WebResponse<ArrayList<Country>> response) {
        return response != null && response.getResult() != null;
    }
});