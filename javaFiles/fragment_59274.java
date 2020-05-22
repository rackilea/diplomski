class MyService {
  private static class Holder {
    private static final MyService INSTANCE = new MyService();
  }

  static MyService getInstance() {
    return Holder.INSTANCE;
  }
}