Observable.from(jsonFile).flatMap(new Func1<File, Observable<String>>() {
    @Override public Observable<String> call(File file) {
        try {
            return Observable.just(new Gson().toJson(new FileReader(file), Object.class));
        } catch (FileNotFoundException e) {
            // this static method is a part of rx-java. It will return an exception which is associated to the value.
            throw OnErrorThrowable.addValueAsLastCause(e, file);
            // alternatively, you can return Obersable.empty(); instead of throwing exception
        }
    }
});