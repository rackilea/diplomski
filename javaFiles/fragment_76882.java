ismatch = true;
  for (int k = 0; k < number.length - 1; k++) {
    for (int l = 0; l < number.length - 1; l++) {
      if (number[k][l] != number[l][k]) {
        ismatch = false;
        break;
      }
    }
  }