public class Main {
  private static int i = 0;

  public static void main(String[] args) {
    switch(sideEffect()) {
      case 0:
        System.out.println("0");
        break;
      case 1:
        System.out.println("1");
        break;
      default:
        System.out.println("something else");
    }

    System.out.println(i); //this prints 1
  }

  private static int sideEffect() {
    return i++;
  }
}