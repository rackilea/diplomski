final OkHttpClient client = new OkHttpClient();
Observable.defer(new Func0<Observable<Response>>() {
    @Override public Observable<Response> call() {
        try {
            Response response = client.newCall(new Request.Builder().url("your url").build()).execute();
            return Observable.just(response);
        } catch (IOException e) {
            return Observable.error(e);
        }
    }
});