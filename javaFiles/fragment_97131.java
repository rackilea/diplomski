public class Calculator extends Stack{
public static void main (String []args) {
    Scanner s = new Scanner(System.in);
    Calculator c = new Calculator();
    try
    {
        s = new Scanner(new FileInputStream("numbers.txt"));
        float z = c.calculate (s);

    }