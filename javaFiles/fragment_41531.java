public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter value");
    double myValue = 0;
    if(scanner.hasNextDouble()){
      myValue = scanner.nextDouble();
    }else{
      System.out.println("Wrong value entered");
    }
  }
}