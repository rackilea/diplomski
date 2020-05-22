int[] counts = new int[6];
for(int counter = 0; counter != numDice; counter++)
{
    firstDie.roll();
    playerOneResults[counter] = firstDie.getFaceValue();
    System.out.println("Player one results: " + playerOneResults[counter]);
    counts[playerOneResults[counter]-1]++;
}