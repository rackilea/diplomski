private static CountDownLatch dependencyLatch = new CountDownLatch(1);// 1 = number of dependencies required    
static FooService  fooService = null;   
public void onFooServiceUp(FooService service) {
  fooService = service;
  dependencyLatch.countDown();
}