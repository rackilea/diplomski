Observable.from(jsonFile).map(new Func1<File, String>() {
    @Override public String call(File file) {
        try {
            return new Gson().toJson(new FileReader(file), Object.class);
        } catch (FileNotFoundException e) {
            // this exception is a part of rx-java
            throw OnErrorThrowable.addValueAsLastCause(e, file);
        }
    }
});