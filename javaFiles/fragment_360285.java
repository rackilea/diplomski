int i, j, tobeSorted;
    for (i = 1; i < input.length; i++) {
      tobeSorted = input[i];
      j = i;
      while (j > 0 && input[j - 1] > tobeSorted) {
        input[j] = input[j - 1];
        j--;
      }
      input[j] = tobeSorted;

      println("i: " + i);
    }