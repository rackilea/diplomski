class Main {
  public static void main(String[] args) {
    int N = 5;
    String text = "aaaaabbbbbccccceeeeefff";
    String[] tokens = text.split("(?<=\\G.{" + N + "})");
    for(String t : tokens) {
      System.out.println(t);
    }
  }
}