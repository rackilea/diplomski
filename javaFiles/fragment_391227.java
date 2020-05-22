public class Mother {
  public static void main(String[] args) {
    GetInput inputReader = new GetInput();
    String input = inputReader.read();
    System.out.println(input);
  }

public class GetInput {
  public String read() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }
}