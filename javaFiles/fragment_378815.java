// MAIN METHOD
public static void main(String[] args)
{
  // SET VARIABLES FOR DIE HIGH AND LOW VALUES, NUMBER OF DICE TO ROLL
  final int LOWEST_DIE_VALUE = 1;
  final int HIGHEST_DIE_VALUE = 6;
  final int DICE_TO_ROLL = 5;

  // ROLL A SINGLE DIE VIA METHOD rollADie()
  int roll = rollADie(HIGHEST_DIE_VALUE,LOWEST_DIE_VALUE);
  System.out.println("roll  " + roll);
}