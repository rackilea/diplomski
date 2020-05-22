<T> StreamObserver<T> getTradesResponseStream() {
    return new StreamObserver<T>() {
        @Override
        public void onNext(T response) {
            responseOnNextAction(response);
        }
    };
}