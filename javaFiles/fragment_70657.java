protected <T> void createObserver(Class<T> type) {
    observer = new Observer<T>() { // <-- It's possible to assign types with  arbitrary type arguments to a raw type.
        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onNext(T value) { // <-- Now it's legal
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onComplete() {
        }
    };
}