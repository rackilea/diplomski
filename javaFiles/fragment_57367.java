void doSomething(final String foo) {
  new Thread(new Runnable() {
      @Override
      public void run() {
        // SOME CODE HERE REQUIRES VARIABLE
        System.out.println(foo);
      }
  }).start();
}