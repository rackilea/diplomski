public class ArithmeticMethods {
    public static void main(String [] args) {
        int num1 = 0, num2 = 0;
        double sum, mul;

        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Enter the first number: ");
        num1 = input.nextInt();
        System.out.println("Enter the second number: ");
        num2 = input.nextInt();
        add(num1,num2);
        multiply(num1,num2);

            }
        catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                System.out.println("note: text format is an invalid input.");
        }               
        finally{
            input.close();
        }   

}
    public static void add( int num1, int num2) {
        int sum = num1 + num2;
        display(sum, sum);
    }
    public static void multiply( int num1, int num2) {
        int mul = num1 * num2;
        display(mul,mul);
    }
    public static void display(int sum, int mul) {
        System.out.println("The result after adding the two numbers above is "+ sum +".");
        System.out.println("The result after multiplying the two numbers above is "+ mul +".");
    }
}