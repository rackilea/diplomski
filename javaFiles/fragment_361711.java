import java.util.Scanner;

public class A {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (true) {
        System.out.print("Please call the coin toss (h or t): ");
        String call = input.nextLine();
        String heads = "h";
        String tails = "t";

        if(call==null || call.length() > 1){
            break;
        }

        System.out.println("Tossing...");

        int random=(int)(Math.random()*2);

        if(random<1){ //assume that, if random variable is smaller than 1 then it is head. If bigger than 1 and smaller than 2, then tails.
            if(heads.equals(call)){
                System.out.println("The coin came up heads. You win!");
            }
            else{
                 System.out.println("Sorry, incorrect.");
            }
        }else{
            if(tails.equals(call)){
                System.out.println("The coin came up tails. You win!");
            }
            else{
                 System.out.println("Sorry, incorrect.");
            }
        }

    }
  }
}