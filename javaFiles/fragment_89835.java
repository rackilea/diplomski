<T,E extends Throwable> Observable<T>
 whenExceptionIs(Class<E> what, Func1<E,Observable<T>> result) {
     return t -> {
        return what.isInstance(t) ? result.call(t) : Observable.error(t);
     };
 }