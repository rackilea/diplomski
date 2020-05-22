public static void main(String[] args) {
  AddShutdownHookSample sample = new AddShutdownHookSample();
  sample.attachShutDownHook();
  System.out.println("Last instruction of Program....");
  System.exit(0);
 }