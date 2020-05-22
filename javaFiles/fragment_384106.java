final Producer producer = ...;
int n = ...;
Observable<Object> obs = 
    Observable.interval(n,TimeUnit.SECONDS)
              .map(new Func1<Integer,Object>() {
                  @Override
                  public Object call(Integer i) {
                      return producer.readData();
                  }
               ));