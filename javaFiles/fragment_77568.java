public class Test {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("What is your number?");
    int n = keyboard.nextInt();
    ArrayList<Integer> result =  getHailstonSequence(n);
    System.out.println(result);
  }

  public static ArrayList<Integer> getHailstonSequence(int n) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(n);
    while (n != 1) {
      if (n % 2 == 0) {
        System.out.print(n + " is even so I take half ");
        n = n / 2;
        System.out.println(n);
      }

      else {
        System.out.print(n + " is odd so I make 3n+1 ");
        n = (n * 3) + 1;
        System.out.println(n);
      }
      numbers.add(n);
    }
    return numbers;
  }
}