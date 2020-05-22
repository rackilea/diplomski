public static void main(String[] args) throws Exception {

  Callable<Integer> worker = new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
      Integer i = 0;

      while (i < 10) {
        i++;
        System.out.println("value " + i);
        Thread.sleep(500);
      }

      return i;
    }
  };

  Future<Integer> result = Executors.newSingleThreadExecutor().submit(worker);
  System.out.println(result.get());
}