long[] hobbies = new long[numHumans];
  int size = 0;
  for(int i = 0; i<numHumans; i++) {
      hobby = encodeHobbies(humans.get(i).getHobbies(),
                             bitPositionDictionary);
      for(int j = 0; j<size; j++) {
          if(enoughBitsInCommon(hobbies[j], hobby)) {
              // just record somewhere cheap for later processing
              handleMatch(i,j); 
          }
      }
      hobbies[size++] = hobby;
  }