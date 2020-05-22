import java.util.Scanner;

public class OnlineTest {       
String name;
double id;

public void entry() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please, Enter Your  Full Name :");
    name = input.nextLine();
    System.out.println("Please, Enter your Test Registration ID :");
    id = input.nextDouble();

    System.out.println(" . . . Starting Test\n");

    test(0, 0, 0);
}

public void test(double score1, double score2, double score3) {
    String answer;
    Scanner input = new Scanner(System.in);

    System.out.println("- Choose the Correct Answer:\n");

    do {
        System.out.println("a. Which Utility is used to compile Java applications?\n" + "   1. javaw\n"
                + "   2. java\n" + "   3. javac ");
        answer = input.next();
    } while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3"));

    if (answer.equals("3")) {
        score1 = 100;
    } else if (!answer.equals("3")) {
        score1 = 0;
    }

    do {
        System.out.println(
                "b. Which is a restriction when using a switch statement? \n" + "   1. Characters cannot be used\n"
                        + "   2. Doubles cannot be used\n" + "   3. Integers can not be used");
        answer = input.next();
    } while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3"));

    if (answer.equals("1")) {
        score2 = 100;
    } else if (!answer.equals("1")) {
        score2 = 0;
    }

    do {
        System.out.println("c. What is the range of byte data type in Java?  \n" + "   1. -128 to 127\n"
                + "   2. -32768 to 32767\n" + "   3. -2147483648 to 2147483647");
        answer = input.next();
    } while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3"));

    if (answer.equals("1")) {
        score3 = 100;
    } else if (!answer.equals("1")) {
        score3 = 0;
    }

    double totalscores = score1 + score2 + score3;
    results(totalscores);

}

public void results(double totalscores) {

    double percentage = (totalscores) / 3;
    printData(percentage);
}

public void printData(double percentage) {

    System.out.println("-----------------------");

    System.out.println("\tJava Certification\n" + "\t   Test Results\n");

    System.out.println("Name : " + name);
    System.out.println("Test Registration ID:" + id);

    System.out.println("Passing Score 52% ");
    System.out.println("Your Score : " + percentage + "% \n");

    System.out.println("Max Score --------------------100%\r\n" + "Passing Score -----------52");

}

public static void main(String[] args) {
    OnlineTest onlineTest = new OnlineTest();
    onlineTest.entry();

}
}