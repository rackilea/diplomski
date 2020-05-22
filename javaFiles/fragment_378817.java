public static int[] rollTheDice(int numDiceToRoll, int lowestDieValue, int highestDieValue) {
  int[] allDiceRolls = new int[numDiceToRoll];

  for(int i = 0; i < allDiceRolls.length; i++) {
    allDiceRolls[i] = rollADie(lowestDieValue, highestDieValue);
  }

  return allDiceRolls;
}