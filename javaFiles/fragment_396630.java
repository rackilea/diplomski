public static void main(String[] args) {
    DynamicMethodInvocation x = new DynamicMethodInvocation();

    Class<?> clX = x.getClass(); // added the generic ?
    ...
  }