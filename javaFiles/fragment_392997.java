class TimerAdvice {
  @Advice.OnMethodEnter
  static long enter() {
    return System.currentTimeMillis();
  }
  @Advice.OnMethodExit(onException = Throwable.class)
  static void exit(@Advice.Origin String method, @Advice.Enter long start) {
    System.out.println(method + " took " + (System.currentTimeMillis() - start));
  }
}