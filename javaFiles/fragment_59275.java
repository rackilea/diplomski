static MyService getInstance() {
  if (instance == null) {
    synchronized (MyService.class) {
      if (instance == null) {
        instance = new MyService();
      }
    }
  }
  return instance;
}