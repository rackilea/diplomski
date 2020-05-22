public static void printToOutAndErr(String toOut, String toErr) {
  synchronized(System.out) {
     System.out.println(toOut);
     System.err.println(toErr);
  }
}