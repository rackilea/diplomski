public Object giveMeNewObject() {
    CountDownLatch latch=new CountDownLatch(1);
    Callback callback=new Callback() { 
      public sometype result=null;
        @Override
        public void onSuccess(Object somethingNew) {
            result = somethingNew; //ERROR; can't set cause final
            latch.countDown();
        }
    });
    SomeApiClient.start(callback);
    latch.await(sometimetowait);
    return callback.result;

}