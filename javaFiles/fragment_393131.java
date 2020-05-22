import java.util.Scanner;

public abstract class StringReverse {
    private static Scanner input;

    public static void main(String[] args){
        System.out.println("Enter a string: ");
        input = new Scanner(System.in);
        String str = input.next();
        char[] strArray = str.toCharArray();

        for (int i = strArray.length - 1; i >= 0; i--)
        {
            System.out.print(strArray[i]);
        }
    }
}