import java.util.*;

public class MyJavaProgram
{
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {    
        int number1 = console.nextInt();
        int number2 = console.nextInt();
        int number3 = console.nextInt();
        System.out.println("Volume = "+ ((number1 * number2) + number3));
    }
}