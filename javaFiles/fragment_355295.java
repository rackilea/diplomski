import java.util.Scanner;

public class calculator {

public static void main(String args[]) {
    // no need of two Scanners to read the same stream
    //   Scanner operation = new Scanner(System.in);
    //  Scanner number = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    int x;
    int y;
    // can't declare variables like this in java
    //        int problem = multiplication, division, addition, subtraction;
    //        int answer = answerM, answerD, answerA, answerS;
    int answer = 0;

    System.out.println("enter first number: ");
    x = input.nextInt();
    System.out.println("enter operator: ");
    // you can't assign a value to a method call
    //signs(); = operation.nextInt();
    String sign = input.next();
    System.out.println("enter second number: ");
    y = input.nextInt();
    //        System.out.println(answer);


   //        if (problem == signs()) {
   //            answerM = x * y;
   //        } else {
   //            if (problem = signs()) {
  //                answerD = x / y;
  //            } else {
  //                if (problem == signs()) {
  //                    answerA = x + y;
  //                } else {
  //                    if (problem == signs()) {
  //                        answerS = x - y;
  //                    }
  //                }
  //            }
  //        }
    if (sign.equals("*")) {
        answer = x * y;
    } else {
        if (sign.equals("/")) {
            answer = x / y;
        } else {
            if (sign.equals("+")) {
                answer = x + y;
            } else {
                if (sign.equals("-")) {
                    answer = x - y;
                }
            }
        }
    }
    System.out.println(answer);

}
   //This method  always return '0'
  //    private static int signs() {
  //        multiplication = "*";
  //        division = "/";
  //        addition = "+";
  //        subtraction = "-";
  //        return 0;
  //    }
  }