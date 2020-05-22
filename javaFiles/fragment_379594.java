protected fun <T> onNetworkError(): ObservableTransformer<T, T> {
    return ObservableTransformer { observable ->
        observable
                .doOnError({ throwable -> networkError.setValue(throwable) })
    }
}