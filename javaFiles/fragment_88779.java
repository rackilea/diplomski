public static void main() {
  Thread t = new Thread(() -> {
    try {
      TimeUnit.HOURS.sleep(30);
    } catch (InterruptedException e) {}
  });
  t.start(); // to prevent natural JVM exit when main dies

  ArrayList<Long[]> retain = new ArrayList<>();
  while (true) {
    Long[] arr = new Long[Integer.MAX_VALUE];
    retain.add(arr);
  }
}