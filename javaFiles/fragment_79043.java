public static Observable<List<String>> _getObservable() {
    return TestPackage.getObservable().map(new Func1<List<? extends String>, List<String>>() {
        @Override
        public List<String> call(List<? extends String> list) {
            return Collections.unmodifiableList(list);
        }
    });
}