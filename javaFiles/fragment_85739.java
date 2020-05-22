Single.just(123)
.zipWith(getConstant(), this::add)
.flatMap(sum -> 
     doSomething(getObject(sum))
     .andThen(Single.just(sum))
);