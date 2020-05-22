import java.util.*;

public class Final {

  public static void main(String[] args) {
    System.out.print("Enter Player's Free Throw Percentage: ");
    Scanner input = new Scanner(System.in);
    int percent = input.nextInt();
    int[] shots = getRandomNumbers();
    print(shots);
  }

  public static int[] getRandomNumbers(){
    int [] shots = new int [10];
    Random r = new Random();
    for(int i = 0; i < 10; i++) {
      shots[i] = r.nextInt(100);
    }
    return shots;
  }

  public static void print(int[] shots) {
    for (int i=0; i<shots.length; i++) {
      System.out.print(shots[i]);
      if (i < shots.length-1) {
        System.out.print(", ");
      }
      else {
        System.out.println("");
      }
    }
  }

}//END class