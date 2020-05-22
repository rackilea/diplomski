package usingoperators;

public class UsingOperators 
{
   public static void main(String[] args) 
    {
        MathDemo test1 = new MathDemo(); // creates test1 object

        int result = test1.add(1, 2); // Calculate 1 + 2 and store result in variable
        test1.printResult(result); // pass result to method to print it
    }
}