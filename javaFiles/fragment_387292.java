for(int i=0; i<52 ; i++){
    index = number.nextInt(52);
    for(i=0; i<52 ; i++){
      while(index == indexChecker[i])
      index = number.nextInt(52);
    }
    temp[i] = deck[index]; //The error is here
  }