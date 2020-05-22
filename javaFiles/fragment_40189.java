public class SampleJava {
    public static String stupid() {
      System.out.println("stupid");
      return "stupid";
    }
    public static void main(String[] args) {
      System.out.println(Optional.ofNullable("smart").orElseGet(() -> stupid()));
    }
}