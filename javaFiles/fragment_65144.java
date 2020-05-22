import java.util.Scanner;

public class BattleofNumbers {

  double[] nums;
  int amount, round = 0;

  double champ;

  Scanner in;

  public BattleofNumbers() {
      in = new Scanner(System.in);
      initValues();
      processGame();
  }

  public void processGame() {
      champ = calcChamp(nums);
      System.out.println("=====================");
      System.out.println("The Champion: " + champ);
      System.out.println("No. of Rounds: " + round);
      System.out.println("No. of Brackets: "
            + (int) Math.ceil((double) round / 2));
  }

  private void initValues() {
      System.out.println("Please enter amount of numbers:");
      amount = in.nextInt();

      nums = new double[amount];

      for (int i = 0; i < amount; i++) {
          System.out.println("Please enter " + (i + 1) + ". number:");
          nums[i] = in.nextDouble();
      }

      System.out.println("");
  }

  public double calcChamp(double[] nums) {
      double[] nexts = new double[(int)Math.ceil(((double) nums.length / 2))];

      for (int first = 0, second = (nums.length - 1); first <= second; first++, second--) {
          if (nums[first] > nums[second]) {
              nexts[first] = nums[first];
          } else {
              nexts[first] = nums[second];
          }
          round++;
          System.out
                .println("Winner of round " + round + ": " + nexts[first]);
      } 

      if (nexts.length == 1) {
          return nexts[0];
      } else {
          return calcChamp(nexts);
      }
  }

  public static void main(String[] args) {
      new BattleofNumbers();
  }