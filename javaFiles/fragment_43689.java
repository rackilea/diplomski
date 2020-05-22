public static void main(String[] args) {
    Timer clock = new Timer();
    clock.schedule(new TimerTask() {
          @Override
          public void run() {
              System.out.print("Total: " + Runtime.getRuntime().totalMemory());
              System.out.println(" Free: " + Runtime.getRuntime().freeMemory());

          }
        }, 1*1*1000, 1*1*1000);// One second intervals

    // now use memory
    ArrayList<Object> arrays = new ArrayList<>();
    for (int i = 0; i < 1_000_000; ++i) {
        ArrayList<String> strings = new ArrayList<>();
        for (int j = 0; j < 1_000_000; ++j) {
            strings.add("" + j);
        }
        arrays.add(strings);
    }
    System.out.println("Loop complete");
}