Observable.from(jsonFile).flatMap(new Func1<File, Observable<String>>() {
    @Override public Observable<String> call(File file) {
        try {
            return Observable.just(new Gson().toJson(new FileReader(file), Object.class));
        } catch (FileNotFoundException e) {
            return Observable.error(OnErrorThrowable.addValueAsLastCause(e, file));
        }
    }
});