for(int i = 0; i<usednum.length; i++) {
           while(usednum[i]==0) {
              randNum = rand.nextInt(numbers.length-min+1)+min;
              for(int f = 0; f<usednum.length; f++) {
                 if(usednum[f] == randNum) {
                    break;
                 } //if                                                                                                                                        
                 else if (usednum[f] == 0) {
                    usednum[i] = randNum;
                 }
              }
           }
        }