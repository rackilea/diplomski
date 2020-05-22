final class EjecutorUpdateContactos {
  void update() throws Exception {
    ExecutorService workers = Executors.newFixedThreadPool(10);
    List<Callable<Void>> tasks = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      int a = i;
      tasks.add(new Callable<Void>() {
        @Override
        public Void call() {
          System.out.println(a);
          return null;
        }
      });
    }
    workers.invokeAll(tasks);
    workers.shutdown();
  }
}