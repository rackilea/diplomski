private static Observable<List<String>> getAcronyms(){
    return Observable.fromCallable(new Callable<List<String>>() {
        @Override
        public List<String> call() throws Exception {
            List<String> strings = new ArrayList<>();
            strings.add("YOLO");
            strings.add("LMAO");
            strings.add("ROFL");
            strings.add("AYY LMAO");
            return strings;
        }
    });
}