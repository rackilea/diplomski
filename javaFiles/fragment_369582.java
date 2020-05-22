public class FactorialClient
{
    public static void main()
   {
      Scanner reader = new Scanner(System.in);  // Reading from System.in
      System.out.println("Enter a number: ");
      int x = reader.nextInt();
      Factorial n = new Factorial();
      System.out.println(n.Factorial(x));
   }
}