static int i = 0;
  public static void rec0() {
      i++;
      rec0();
  }

  public static void main(String[] args) {
      ...
      try {
          i = 0; rec0();
      } catch (StackOverflowError e) {
          System.out.println(i);
      }
      ...
  }