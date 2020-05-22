@Advice.OnMethodEnter
  static void enter(@Advice.Origin String method) {
    System.out.println("enter");
  }

  @Advice.OnMethodExit
  static void exit(@Advice.Origin String method) {
    System.out.println("exit");
  }