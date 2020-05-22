Observable<T> apiCall1WithTimeout = Observable.amb(apiCall1(), 
                                                   Observable.Timer(500, TimeUnit.MILLISECONDS)
                                                             .flatmap(l -> Observable.error(new Exception("Api1 timed out")));
Observable<T> apiCall2WithTimeout = Observable.amb(apiCall2(), 
                                                   Observable.Timer(500, TimeUnit.MILLISECONDS)
                                                             .flatmap(l -> Observable.error(new Exception("Api2 timed out"))));