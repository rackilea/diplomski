int[] frequencies = new int[6];

for (int counter = 0; counter < 100; counter++) {
  int index = rand.nextInt(diceArray.length);
  dice = diceArray[index];
  frequencies[index]++;
}