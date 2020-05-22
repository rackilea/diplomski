public static void interval(int begin, int end, int interval) {
  int time = begin;
  while (time <= end) {
    System.out.println(String.format("%02d:%02d", time / 60, time % 60));
    time += interval;
  }
}