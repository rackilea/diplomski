Observable<T> o1;
Observable<R> o2;

Observable<R> o3 = 
  o1.ignoreElements()
    .castAs(R.class)
    .concatWith(o2);