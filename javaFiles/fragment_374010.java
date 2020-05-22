public class CalculatorTest {
    static Scanner userFirstNumber = new Scanner(System.in);

    public static int reCalculate(int a){
        return a + 5;
    }
    public static void main(String[] args){
        int input;
        System.out.print("Enter a number, I will do the rest : ");
        input = userFirstNumber.nextInt();
        int result = reCalculate(bobson);
        System.out.println(result);

    }
}