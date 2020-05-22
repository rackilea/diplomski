TestBuilder<String, String> testBuilder = new TestBuilder<>(String.class);
 testBuilder.withOnNext(new Action1<String>() {
     @Override
     public void call(String string) {
         //...
     }
 });