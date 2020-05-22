Observable<String> stringStream = stringStreamInput
  .observeOn(Schedulers.io())
  .flatMap( input -> getPerroDetails(input) )
  .publish();

stringStream.connect();