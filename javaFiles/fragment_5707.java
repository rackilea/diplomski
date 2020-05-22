import java.util.Scanner;
public class PatternTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userInput;
        System.out.println("Please enter a number 1...9 : ");
        userInput = in.nextInt();
        String s="";
        int temp = userInput;
        for(int i=1; i<=userInput; i++ ) {

            for (int k= userInput; k>i; k-- ) { // <- corrected condition
                System.out.printf("  ");
            }

            for(int j = i; j>=1; j-- ) {
                System.out.print(j);

                // check if not 1 to avoid a trailing space
                if (j != 1) {
                    System.out.print(" ");
                }
            }


            System.out.println("");
        }

    }

}