import java.util.Scanner;
public class ElementaryMath {

    private double num1;
    private double num2;
    private String opType;
    private static int numCorrect;
    private int actualAns;

    ElementaryMath(double n1, double n2, String ot){
        num1=n1;
        num2=n2;
        opType=ot;
    }

    public void printQuestion(){
        System.out.println((int)num1 + " " + opType + " " + (int)num2);
    }

    public void checkAnswer(int ans, String op){

        if(op.equals("/")) {
            actualAns = (int) num1 / (int) num2;
            System.out.println("answer is " + actualAns +" "+ ans);
            if(actualAns == ans)
            {
                numCorrect++;
            }
        }
        if(op.equals("*")){
            actualAns = (int) num1 * (int) num2;
            System.out.println("answer is " + actualAns + " " + ans);
            if(actualAns == ans)
            {
                numCorrect++;
            }
        }
    }

    public String numCorr(){
        return ""+numCorrect+"";
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        double n1, n2;
        String op = "";
        int nq, qt, aq;

        System.out.println("Which option would you like?");
        System.out.println("1. Single Digit - One operation");
        System.out.println("2. Two Digit -  One operation.");
        System.out.println("3. Single Digit - Multiple Operations (Mixed operators)");
        System.out.println("");
        System.out.println("Please enter your option. (1, 2, or 3): ");
        qt = in.nextInt();
        if(qt==1 || qt==2) {
            System.out.println("Please enter which operator you would like to use: (type / or * )");
            op = in.next();
        }
        System.out.println("Enter the number of questions you would like: ");
        nq = in.nextInt();

        if(qt==1 || qt==2)
        {
            for(int i=0;i<nq;i++) {
                n1 = Math.random() * 9 + 1;
                n2 = Math.random() * 9 + 1;
                ElementaryMath a = new ElementaryMath(n1, n2, op);
                a.printQuestion();
                System.out.println("Please print your answer: ");
                aq = in.nextInt();
                a.checkAnswer(aq, op);
                if(i==(nq-1)) {
                    System.out.println("You have successfully answered " + numCorrect + " out of " + nq + " questions correctly.");
                }
            }
        }
    }
}