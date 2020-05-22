for (int i = 0; i < 10; i++){
      if (input[i] > max){
        secondMax = max;
        max = input[i];
      }

      if ((input[i] < max) && (input[i] > secondMax))
        secondMax = input[i];
    }