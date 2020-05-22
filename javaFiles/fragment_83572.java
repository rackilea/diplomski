public static int getNumOfCows(int[] secretNumber, int[] guessedNumber) {
    int max = secretNumber.length;
    int cows = 0;
    int[] checked = new int[max];
    for (int i = 0; i < max; i++) {
        if (secretNumber[i] == guessedNumber[i]) {
          checked[i] = 1;
        }
    }

    for (int i = 0; i < max; i++) {
      if (checked[i] == 1) {
        continue;
      }
      for (int j = 0; j < max; j++) {
        if (secretNumber[i] == guessedNumber[j]) {
          cows++;
          checked[i] = 1;
        }
      }
    }
    return cows;
}