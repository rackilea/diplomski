import java.util.Scanner;

public class TestMainResuse {

    public static void main(String[] args) {
        System.out.println("Step:1. This program takes input in the following structure that looks like array declaration:\nint[]num=new int[]{1,2,3}");
        System.out.println("Step:2. The program should ignore all the strings and accept only the numeric value (i.e. in this case it is: 1,2,3).");
        System.out.println("Step:3. The program then add the numners (i.e. 1+2+3) and print out the sum");
        System.out.println("***********************\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Write input: ");
        while (true) {
            try {
                String array = sc.nextLine();
                if (array.contains("int") || array.contains("float") || array.contains("double")) {

                    double sum = 0;
                    int start = array.indexOf('{');
                    int end = array.indexOf('}');
                    String strNum = array.substring(start+1, end);
                    String[] strArray = strNum.split(",");
                    for (String s : strArray) {
                        sum += Double.parseDouble(s.trim());  
                    }
                    System.out.printf("The sum of the array: %.5f", sum);

                } else {
                    System.out.println("Wrong input! Try again");
                }
            } catch (Exception e) {
                System.err.println("Wrong input! Try again");
            }
        }

    }

}