import java.util.Scanner;

public class Program {
public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    int num = 0;
    int counter = 0;
    Math math1 = new Math(num, counter);
    while (num != 999) {
        num = kb.nextInt();
        if (num != 999) {
            math1.adder(num);
            counter ++;
            math1.setCounter(counter);
            System.out.println("Total till now:" + math1.getNumTotal());
        }
    }
    System.out.println(math1.getNumTotal());
    System.out.println(math1.getCalcMean());
    //System.out.println(math1.getNum());
    kb.close();
    /*Scanner kb = new Scanner(System.in);
    String input = kb.nextLine();
    Scanner scn = new Scanner(input);
    int num = scn.nextInt();
    Math math1 = new Math(num,0);
    while(num != 999){
        math1.adder(num);
        input = kb.nextLine();
    }

    System.out.println(math1.getNumTotal());*/
} //main
}